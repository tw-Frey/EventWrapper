@file:Suppress("unused")

package tw.idv.fy.model

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 * [ref](https://gist.github.com/JoseAlcerreca/5b661f1800e1e654f07cc54fe87441af)
 */
open class EventWrapper<out T>(private val content: T?) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T? = content
}