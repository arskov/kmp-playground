import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

object SampleTest {
    @Test
    fun sampleTest() {
        val samp = SampleClass("Default", ByteArray(16) { 0xCA.toByte() })
        assertEquals("Default", samp.name)
        assertContentEquals(samp.sampleByteArray(), samp.bytes)
    }
}