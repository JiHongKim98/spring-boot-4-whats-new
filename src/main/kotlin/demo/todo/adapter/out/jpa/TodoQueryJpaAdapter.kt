package demo.todo.adapter.out.jpa

import demo.todo.adapter.out.jpa.repository.TodoJpaRepository
import demo.todo.application.port.out.TodoQueryRepository
import demo.todo.application.service.model.TodoReadModel
import org.springframework.stereotype.Component

@Component
internal class TodoQueryJpaAdapter(
    private val todoJpaRepository: TodoJpaRepository,
) : TodoQueryRepository {
    override fun getById(id: String): TodoReadModel {
        val todoJpaEntity = todoJpaRepository.findByIdWithoutDelete(id)
            ?: throw JpaException.NotExists()
        return todoJpaEntity.toReadModel()
    }

    override fun getAll(): List<TodoReadModel> {
        val todoJpaEntities = todoJpaRepository.findAllByIdWithoutDelete()
        return todoJpaEntities.map { it.toReadModel() }
    }
}
