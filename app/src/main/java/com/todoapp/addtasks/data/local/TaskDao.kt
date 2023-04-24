package com.todoapp.addtasks.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.todoapp.addtasks.data.entities.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM TaskEntity")
    fun getTask(): Flow<List<TaskEntity>>

    @Insert
    suspend fun addTask(item: TaskEntity)

}