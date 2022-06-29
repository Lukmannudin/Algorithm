import junit.framework.TestCase.assertEquals
import org.junit.Test

internal class EuclidAlgorithmTest {

    @Test
    fun `546, 320`() {
        assertEquals(EuclidAlgorithm.euclid(546, 320), 2)
    }

    @Test
    fun `18, 24,36`() {
        assertEquals(EuclidAlgorithm.euclid(18, EuclidAlgorithm.euclid(24, 36)), 6)
    }

    @Test
    fun `1680, 640`() {
        assertEquals(EuclidAlgorithm.euclid(1680, 640), 80)
    }
}