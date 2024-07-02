package com.example.cleanarchitectureshowcase.features.home.domain

import java.util.UUID

fun interface TaskAdder { fun add(): Boolean }
fun interface TaskGetter { fun getTask(id: UUID): DataTask} //static
fun interface TasksGetter { fun getTaskList(): List<DataTask> }
fun interface TaskUpdater { fun update(): DataTask } // TODO: change diff type
fun interface TaskCompleter { fun completer(): Unit }
fun interface TaskRemover { fun delete(): Unit }