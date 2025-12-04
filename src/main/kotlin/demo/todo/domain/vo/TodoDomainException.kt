package demo.todo.domain.vo

import demo.todo.common.exception.BaseSuppressedException

sealed class TodoDomainException(
    message: String,
) : BaseSuppressedException(message, Type.DOMAIN) {
    class UnMatchAuthorization : TodoDomainException("Unmatch authorization")

    class AlreadyDeleted : TodoDomainException("Already deleted")

    class AlreadyCompleted : TodoDomainException("Already completed")
}
