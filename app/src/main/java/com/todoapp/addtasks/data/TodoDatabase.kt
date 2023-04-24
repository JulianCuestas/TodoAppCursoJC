package com.todoapp.addtasks.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.todoapp.addtasks.data.entities.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {

    abstract fun taskDao(): TaskDao

}