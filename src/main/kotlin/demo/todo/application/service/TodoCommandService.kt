package demo.todo.application.service

import demo.todo.application.port.`in`.CompleteTodoUseCase
import demo.todo.application.port.`in`.CreateTodoUseCase
import demo.todo.application.port.`in`.DeleteTodoUseCase
import demo.todo.application.port.`in`.UpdateTodoUseCase
import demo.todo.application.port.out.TodoCommandRepository
import demo.todo.domain.entity.TodoEntity
import org.springframework.stereotype.Service

@Service
internal class TodoCommandService(
    private val todoCommandRepository: TodoCommandRepository,
) : CreateTodoUseCase,
    UpdateTodoUseCase,
    DeleteTodoUseCase,
    CompleteTodoUseCase {
    override fun execute(command: CreateTodoUseCase.Command): String {
        val todoEntity = TodoEntity.create(command.toCreateCommand())
        return todoCommandRepository.save(todoEntity).id
    }

    override fun execute(command: UpdateTodoUseCase.Command): String {
        val todoEntity = todoCommandRepository.update(command.id) { todoEntity ->
            todoEntity.update(command.toUpdateTodoCommand())
        }
        return todoEntity.id
    }

    override fun execute(command: DeleteTodoUseCase.Command): String {
        val todoEntity = todoCommandRepository.update(command.id) { todoEntity ->
            todoEntity.delete(command.toDeleteCommand())
        }
        return todoEntity.id
    }

    override fun execute(command: CompleteTodoUseCase.Command): String {
        val todoEntity = todoCommandRepository.update(command.id) { todoEntity ->
            todoEntity.complete(command.toCompleteTodoCommand())
        }
        return todoEntity.id
    }
}
