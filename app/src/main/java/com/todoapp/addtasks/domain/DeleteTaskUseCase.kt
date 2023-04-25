package com.todoapp.addtasks.domain

import com.todoapp.addtasks.data.repository.TaskRepository
import com.todoapp.addtasks.ui.model.TaskModel
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {

    suspend operator fun invoke(taskModel: TaskModel) = taskRepository.delete(taskModel)

}