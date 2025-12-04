package demo.todo.application.port.`in`

import demo.todo.domain.vo.TodoDomainCommand

fun interface CreateTodoUseCase {
    data class Command(
        val title: String,
        val description: String,
        val author: String,
    ) {
        fun toCreateCommand(): TodoDomainCommand.Create =
            TodoDomainCommand.Create(
                title = title,
                description = description,
                author = author,
            )
    }

    /**
     * 생성된 투두의 식별자를 반환합니다.
     */
    fun execute(command: Command): String
}
