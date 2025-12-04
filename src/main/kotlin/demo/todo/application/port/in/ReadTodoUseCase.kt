package demo.todo.application.port.`in`

import demo.todo.application.service.model.TodoReadModel

fun interface ReadTodoUseCase {
    data class Query(
        val id: String,
    )

    fun execute(query: Query): TodoReadModel
}
