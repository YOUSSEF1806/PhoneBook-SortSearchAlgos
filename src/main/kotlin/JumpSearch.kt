import kotlin.math.floor
import kotlin.math.min
import kotlin.math.sqrt

fun jumpSearch(sortedData: List<String>, value: String): Int {
    val step = floor(sqrt(sortedData.size.toDouble())).toInt()
    var current = 0
    var prev = 0
    if (sortedData.isEmpty())
        return -1
    while (sortedData[current].getFullName() > value.trim()) {
        if (current == sortedData.lastIndex) {
            return -1
        }
        prev = current
        current = min(current + step, sortedData.lastIndex)
    }
    while (sortedData[current].getFullName() < value.trim()) {
        current--
        if (current <= prev) {
            return -1
        }
    }
    if (sortedData[current].getFullName() == value.trim())
        return current
    return -1
}