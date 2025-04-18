fun main() {
    val service = WallService()


    val post1 = Post(
        id = 0,
        ownerId = 123,
        fromId = 123,
        date = System.currentTimeMillis(),
        text = "Первый пост"
    )
    val addedPost = service.add(post1)
    println("Добавлен пост с ID: ${addedPost.id}")


    val updatedPost = addedPost.copy(text = "Обновленный текст")
    val isUpdated = service.update(updatedPost)
    println("Пост обновлен: $isUpdated")


    val fakePost = Post(
        id = 999,
        ownerId = 123,
        fromId = 123,
        date = System.currentTimeMillis(),
        text = "Фейковый пост"
    )
    println("Пост обновлен: ${service.update(fakePost)}")
}