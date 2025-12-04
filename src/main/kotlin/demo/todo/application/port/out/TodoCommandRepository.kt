package demo.todo.application.port.out

import demo.todo.domain.entity.TodoEntity

interface TodoCommandRepository {
    fun save(todoEntity: TodoEntity): TodoEntity

    fun update(
        id: String,
        modifier: (TodoEntity) -> TodoEntity,
    ): TodoEntity
}
