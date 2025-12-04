package demo.todo.application.port.`in`

import demo.todo.domain.vo.TodoDomainCommand

fun interface CompleteTodoUseCase {
    data class Command(
        val id: String,
        val author: String,
    ) {
        fun toCompleteTodoCommand(): TodoDomainCommand.Complete =
            TodoDomainCommand.Complete(
                author = author,
            )
    }

    fun execute(command: Command): String
}
