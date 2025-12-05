package demo.todo.adapter.out.jpa.vo

import demo.todo.common.exception.BaseSuppressedException

sealed class JpaException(
    message: String,
) : BaseSuppressedException(message, Type.INFRA) {
    class NotFound : JpaException("Not Found")
}
