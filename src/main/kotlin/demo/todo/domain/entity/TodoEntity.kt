package demo.todo.domain.entity

import demo.todo.domain.vo.TodoDomainCommand
import demo.todo.domain.vo.TodoDomainException
import java.util.UUID

data class TodoEntity(
    val id: String,
    val title: String,
    val description: String,
    val author: String,
    val status: Status,
) {
    enum class Status {
        PENDING,
        COMPLETED,
        DELETED,
    }

    fun update(command: TodoDomainCommand.Update): TodoEntity {
        validate(command.author)

        return copy(
            title = command.title,
            description = command.description,
        )
    }

    fun complete(command: TodoDomainCommand.Complete): TodoEntity {
        validate(command.author)

        if (status == Status.COMPLETED) throw TodoDomainException.AlreadyCompleted()

        return copy(
            status = Status.COMPLETED,
        )
    }

    fun delete(command: TodoDomainCommand.Delete): TodoEntity {
        validate(command.author)

        return copy(
            status = Status.DELETED,
        )
    }

    /**
     * 도메인 로직 수행 전 검증 로직
     */
    private fun validate(author: String) {
        when {
            this.author != author -> throw TodoDomainException.UnMatchAuthorization()
            status == Status.DELETED -> throw TodoDomainException.AlreadyDeleted()
        }
    }

    companion object {
        fun create(command: TodoDomainCommand.Create): TodoEntity =
            TodoEntity(
                id = UUID.randomUUID().toString().substring(0, 8),
                title = command.title,
                description = command.description,
                author = command.author,
                status = Status.PENDING,
            )
    }
}
