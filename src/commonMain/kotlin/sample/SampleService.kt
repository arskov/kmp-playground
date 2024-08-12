package sample

class SampleService(private val store: SampleInterface) {
    fun useStore() {
        store.storeInt(10)
        store.storeString("Test")
    }
}