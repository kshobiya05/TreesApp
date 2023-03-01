package com.example.common.common

interface DataState<T> {
    val data: T?
}
class DataStateSuccess<T>(override val data: T?) : DataState<T> {}
class DataStateError<T>(override val data: T?) : DataState<T> {}
class DataStateLoading<T>(override val data: T?) : DataState<T> {}
class DataStateIdle<T>(override val data: T?) : DataState<T> {}