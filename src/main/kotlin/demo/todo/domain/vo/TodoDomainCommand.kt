package demo.todo.domain.vo

/**
 * 투두 도메인 기본 Command
 */
sealed class TodoDomainCommand {
    data class Create(
        val title: String,
        val description: String,
        val author: String,
    ) : TodoDomainCommand()

    data class Update(
        val title: String,
        val description: String,
        val author: String,
    ) : TodoDomainCommand()

    data class Complete(
        val author: String,
    ) : TodoDomainCommand()

    data class Delete(
        val author: String,
    ) : TodoDomainCommand()
}
