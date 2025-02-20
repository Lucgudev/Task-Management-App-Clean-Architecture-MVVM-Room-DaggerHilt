package com.lucgu.taskme.domain.repository

import com.lucgu.taskme.data.entities.DataState
import com.lucgu.taskme.data.entities.TaskEntity
import com.lucgu.taskme.data.entities.TaskStatus
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun getAllTasks(): Flow<DataState<List<TaskEntity>>>
    suspend fun getTaskByStatus(status: TaskStatus): Flow<DataState<List<TaskEntity>>>
    suspend fun insertTask(task: TaskEntity) : Flow<DataState<Boolean>>
    suspend fun updateTask(task: TaskEntity) : Flow<DataState<Boolean>>
    suspend fun deleteTask(task: TaskEntity) : Flow<DataState<Boolean>>
}