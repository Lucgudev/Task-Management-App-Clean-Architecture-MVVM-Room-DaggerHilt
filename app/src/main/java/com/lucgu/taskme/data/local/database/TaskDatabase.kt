package com.lucgu.taskme.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lucgu.taskme.data.entities.TaskEntity
import com.lucgu.taskme.data.local.dao.TaskDao

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}