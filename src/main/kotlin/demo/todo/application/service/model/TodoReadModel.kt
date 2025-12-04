package demo.todo.application.service.model

data class TodoReadModel(
    val id: String,
    val title: String,
    val description: String,
    val author: String,
    val status: String,
)
