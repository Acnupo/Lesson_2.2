import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WallServiceTest {
    private val service = WallService()

    @BeforeEach
    fun clearBeforeTest() {
        service.clear()
    }

    @Test
    fun addShouldAssignNonZeroId() {
        val post = Post(
            id = 0,
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis(),
            text = "Test post"
        )

        val result = service.add(post)
        assertNotEquals(0, result.id)
    }

    @Test
    fun updateShouldReturnTrueWhenPostExists() {
        val originalPost = Post(
            id = 0,
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis(),
            text = "Original post"
        )
        val addedPost = service.add(originalPost)
        val updatedPost = addedPost.copy(text = "Updated text")

        assertTrue(service.update(updatedPost))
    }

    @Test
    fun updateShouldReturnFalseWhenPostDoesNotExist() {
        val nonExistingPost = Post(
            id = 999,
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis(),
            text = "Non-existing post"
        )

        assertFalse(service.update(nonExistingPost))
    }
}