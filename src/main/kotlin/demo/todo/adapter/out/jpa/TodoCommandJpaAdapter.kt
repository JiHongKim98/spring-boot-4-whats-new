package demo.todo.adapter.out.jpa

import demo.todo.adapter.out.jpa.entity.TodoJpaEntity
import demo.todo.adapter.out.jpa.repository.TodoJpaRepository
import demo.todo.adapter.out.jpa.vo.JpaException
import demo.todo.application.port.out.TodoCommandRepository
import demo.todo.domain.entity.TodoEntity
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
internal class TodoCommandJpaAdapter(
    private val todoJpaRepository: TodoJpaRepository,
) : TodoCommandRepository {
    @Transactional
    override fun save(todoEntity: TodoEntity): TodoEntity {
        val jpaEntity = TodoJpaEntity.fromDomainEntity(todoEntity)
        return todoJpaRepository.save(jpaEntity).toDomainEntity()
    }

    @Transactional
    override fun update(
        id: String,
        modifier: (TodoEntity) -> TodoEntity,
    ): TodoEntity {
        val todoJpaEntity = todoJpaRepository.findByIdOrNull(id)
            ?: throw JpaException.NotFound()

        val todoEntity = modifier.invoke(todoJpaEntity.toDomainEntity())
        todoJpaEntity.update(todoEntity)

        return todoJpaRepository.save(todoJpaEntity).toDomainEntity()
    }
}
