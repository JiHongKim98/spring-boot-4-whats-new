package demo.todo.application.service

import demo.todo.application.port.`in`.ReadAllTodoUseCase
import demo.todo.application.port.`in`.ReadTodoUseCase
import demo.todo.application.port.out.TodoQueryRepository
import demo.todo.application.service.model.TodoReadModel
import org.springframework.stereotype.Service

@Service
internal class TodoQueryService(
    private val todoQueryRepository: TodoQueryRepository,
) : ReadTodoUseCase,
    ReadAllTodoUseCase {
    override fun execute(query: ReadTodoUseCase.Query): TodoReadModel = todoQueryRepository.getById(query.id)

    override fun execute(): List<TodoReadModel> = todoQueryRepository.getAll()
}
