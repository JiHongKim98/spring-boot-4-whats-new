package demo.todo.application.port.out

import demo.todo.application.service.model.TodoReadModel

interface TodoQueryRepository {
    fun getById(id: String): TodoReadModel

    fun getAll(): List<TodoReadModel>
}
