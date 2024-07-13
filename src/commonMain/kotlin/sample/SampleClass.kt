class SampleClass {
    var name: String
    var bytes: ByteArray

    constructor() {
        this.name = "Default"
        this.bytes = byteArrayOf()
    }

    constructor(name: String) {
        this.name = name
        this.bytes = byteArrayOf()
    }

    constructor(name: String, bytes: ByteArray) {
        this.name = name
        this.bytes = bytes
    }

    fun sampleArrayOfBytes(): Array<Byte> {
        return Array<Byte>(16) { 0xFE.toByte() }
    }

    fun sampleByteArray(): ByteArray {
        return ByteArray(16) { 0xCA.toByte() }
    }

    fun printByteArray(bytes: ByteArray) {
        println(bytes.contentToString())
    }

    fun printString(str: String) {
        println(str)
    }

    fun sampleString(): String {
        return "Sample String"
    }
}