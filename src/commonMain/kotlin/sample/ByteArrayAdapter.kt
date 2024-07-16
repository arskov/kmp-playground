package sample

import kotlinx.cinterop.*

class ByteArrayAdapter(val byteArray: ByteArray) {
    fun size() = byteArray.size
    fun get(idx: Int) = byteArray[idx]
    fun set(idx: Int, abyte: Byte) {
        byteArray[idx] = abyte
    }
}

fun sampleByteArray(): ByteArray {
    // DEAD BEEF CAFE
    return byteArrayOf(
        0xDE.toByte(),
        0xAD.toByte(),
        0xBE.toByte(),
        0xEF.toByte(),
        0xCA.toByte(),
        0xFE.toByte())
}

fun createByteArray(asize: Int): ByteArray {
    return ByteArray(asize)
}

fun createByteArrayFromNative(arrayPointer: CArrayPointer<*>, asize: Int): ByteArray {
    return arrayPointer.readBytes(asize)
}

fun getSize(byteArray: ByteArray): Int = byteArray.size
fun getByte(byteArray: ByteArray, idx: Int) = byteArray[idx]
fun setByte(byteArray: ByteArray, idx: Int, abyte: Byte) {
    byteArray[idx] = abyte
}
fun toNativePtr(byteArray: ByteArray): CPointer<ByteVar> {
    return byteArray.pin().addressOf(0)
}