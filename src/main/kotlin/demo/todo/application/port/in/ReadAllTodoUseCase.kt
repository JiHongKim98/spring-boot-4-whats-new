package demo.todo.application.port.`in`

import demo.todo.application.service.model.TodoReadModel

fun interface ReadAllTodoUseCase {
    fun execute(): List<TodoReadModel>
}
