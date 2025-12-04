package demo.todo.application.port.`in`

import demo.todo.domain.vo.TodoDomainCommand

fun interface UpdateTodoUseCase {
    data class Command(
        val id: String,
        val title: String,
        val description: String,
        val author: String,
    ) {
        fun toUpdateTodoCommand(): TodoDomainCommand.Update =
            TodoDomainCommand.Update(
                title = title,
                description = description,
                author = author,
            )
    }

    fun execute(command: Command): String
}
