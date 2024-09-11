package com.example.cleanarchitectureshowcase.features.home.presentation.behaviors

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.example.cleanarchitectureshowcase.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlin.math.max
import kotlin.math.min
import kotlin.properties.Delegates

class OverScrollBehavior() : AppBarLayout.Behavior() {
    constructor(ctx: Context, attrs: AttributeSet) : this()

    private lateinit var targetView: View
    private lateinit var collapsingView: FrameLayout
    private var collapsedHeight by Delegates.notNull<Int>()
    private var unCollapsedHeight: Int = 600
    private var targetHeight: Int = 0
    private var actionBarSize: Int = 0
    private var totalDy: Int = 0
    private var lastBottom: Int = 0
    private var isStoped: Boolean = false


    override fun onLayoutChild(
        parent: CoordinatorLayout,
        abl: AppBarLayout,
        layoutDirection: Int
    ): Boolean {
        val superLayout = super.onLayoutChild(parent, abl, layoutDirection)
        if (!::targetView.isInitialized) initialize(abl)
        return superLayout
    }

    override fun onStartNestedScroll(
        parent: CoordinatorLayout,
        child: AppBarLayout,
        directTargetChild: View,
        target: View,
        nestedScrollAxes: Int,
        type: Int
    ): Boolean {
        isStoped = false
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onStopNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        abl: AppBarLayout,
        target: View,
        type: Int
    ) {
        isStoped = true
        restore(abl)
        super.onStopNestedScroll(coordinatorLayout, abl, target, type)
    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: AppBarLayout,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
        Log.d("animation", "onNestedPreScroll() dy=$dy")
        val ablBottom = child.bottom
        Log.d("animation", "$ablBottom, $targetHeight, $collapsedHeight")
        if ((dy < 0 &&  ablBottom < unCollapsedHeight) || (dy > 0 && ablBottom > collapsedHeight)) {
            resize(child, dy)
        }

        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
    }

    private fun resize(abl: AppBarLayout, dy: Int) {
        Log.d("animation", "resize()")
        if (isStoped) return
        totalDy += -dy
        lastBottom = min(targetHeight + totalDy, unCollapsedHeight)
        lastBottom = max(lastBottom, collapsedHeight)
        Log.d("animation", "height: $lastBottom, tDY: $totalDy")
        abl.bottom = lastBottom
        collapsingView.bottom = lastBottom
    }

    private fun restore(abl: AppBarLayout) {
        Log.d("animation", "restore()")
        if (totalDy > 0) {
            totalDy = 0
            val anim = ValueAnimator.ofInt(lastBottom, targetHeight)
            anim.duration = 500
            anim.addUpdateListener {
                val bottomValue = it.animatedValue as Int
                abl.bottom = bottomValue
                collapsingView.bottom = bottomValue
            }
            anim.start()
        }
    }

    private fun initialize(abl: AppBarLayout) {
        targetView = abl.findViewById(R.id.collapsing_toolbar)
        collapsingView = abl.getChildAt(0) as CollapsingToolbarLayout
        actionBarSize = getActionBarSize(abl.context)
        collapsedHeight = abl.height
        targetHeight = collapsedHeight
    }

    private fun getActionBarSize(context: Context): Int {
        val typedValue = TypedValue()
        val actionBarSize = if (context.theme.resolveAttribute(android.R.attr.actionBarSize, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, context.resources.displayMetrics)
        } else 0
        return actionBarSize
    }
}