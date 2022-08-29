package tomislav.ferit.remi

import android.util.Log

class RandomIntIterator(
    private val range: IntRange
) : Iterator<Int> {

    private lateinit var iterator: Iterator<Int>

    init {
        randomize()
    }

    fun randomize() {
        iterator = range.shuffled().iterator()
        //Returns a new list with the elements of this list randomly
        // shuffled using the specified random instance as the source of randomness.
    }

    override fun hasNext() = iterator.hasNext()
    override fun next() = iterator.next()
}