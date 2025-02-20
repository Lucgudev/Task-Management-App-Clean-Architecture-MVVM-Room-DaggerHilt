package com.lucgu.taskme.data.repository

import com.lucgu.taskme.data.entities.DataState
import com.lucgu.taskme.data.entities.TaskEntity
import com.lucgu.taskme.data.entities.TaskStatus
import com.lucgu.taskme.data.local.dao.TaskDao
import com.lucgu.taskme.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(private val taskDao: TaskDao) : TaskRepository {
    override suspend fun getAllTasks(): Flow<DataState<List<TaskEntity>>> = flow {
        emit(DataState.Loading());
        try {
            taskDao.getAllTasks().collect {
                emit(DataState.Success(it))
            }
        } catch (e: Exception) {
            emit(DataState.Error(e.message))
        }

    }

    override suspend fun getTaskByStatus(status: TaskStatus): Flow<DataState<List<TaskEntity>>> = flow {
        emit(DataState.Loading());
        try {
            taskDao.getTasksByStatus(status).collect {
                emit(DataState.Success(it))
            }
        } catch (e: Exception) {
            emit(DataState.Error(e.message))
        }
    }

    override suspend fun insertTask(task: TaskEntity): Flow<DataState<Boolean>> = flow {
        emit(DataState.Loading());
        try {
            taskDao.insertTask(task)
            emit(DataState.Success(true))
        } catch (e: Exception) {
            emit(DataState.Error(e.message))
        }
    }

    override suspend fun updateTask(task: TaskEntity): Flow<DataState<Boolean>> = flow {
        emit(DataState.Loading());
        try {
            taskDao.updateTask(task)
            emit(DataState.Success(true))
        } catch (e: Exception) {
            emit(DataState.Error(e.message))
        }
    }

    override suspend fun deleteTask(task: TaskEntity): Flow<DataState<Boolean>> = flow {
        emit(DataState.Loading());
        try {
            taskDao.deleteTask(task)
            emit(DataState.Success(true))
        } catch (e: Exception) {
            emit(DataState.Error(e.message))
        }
    }

}