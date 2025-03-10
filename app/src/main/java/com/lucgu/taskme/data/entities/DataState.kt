package com.lucgu.taskme.data.entities

sealed class DataState<T> {
    class Success<T>(val data: T) : DataState<T>()
    class Loading<T> : DataState<T>()
    class Error<T>(val messageError: String?) : DataState<T>()
}