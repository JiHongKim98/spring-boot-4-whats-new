package demo.todo.application.port.`in`

import demo.todo.domain.vo.TodoDomainCommand

fun interface DeleteTodoUseCase {
    data class Command(
        val id: String,
        val author: String,
    ) {
        fun toDeleteCommand(): TodoDomainCommand.Delete =
            TodoDomainCommand.Delete(
                author = author,
            )
    }

    fun execute(command: Command): String
}
