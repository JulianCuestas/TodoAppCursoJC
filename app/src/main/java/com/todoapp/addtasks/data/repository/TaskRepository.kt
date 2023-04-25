package com.todoapp.addtasks.data.repository

import com.todoapp.addtasks.data.local.TaskDao
import com.todoapp.addtasks.data.entities.TaskEntity
import com.todoapp.addtasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor( private val taskDao: TaskDao){

    val tasks: Flow<List<TaskModel>> =
        taskDao.getTask().map { items -> items.map { TaskModel(it.id, it.task, it.selected) } }

    suspend fun add(taskModel: TaskModel) {
        taskDao.addTask(taskModel.modelToEntity())
    }

    suspend fun update(taskModel: TaskModel) {
        taskDao.updateTask(taskModel.modelToEntity())
    }

    suspend fun delete(taskModel: TaskModel) {
        taskDao.deleteTask(taskModel.modelToEntity())
    }

}

fun TaskModel.modelToEntity(): TaskEntity {
    return TaskEntity(this.id, this.task, this.selected)
}