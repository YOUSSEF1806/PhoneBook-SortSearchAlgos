import java.io.File

fun String.getFullName(): String = this.substringAfter(" ").trim()

fun MutableList<String>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun readDataSetFile(dataSetFile: File) = dataSetFile.useLines { it.toList() }

fun Long.millisecondsToHMnSMs() =
    Triple(
        this.div(60 * 1_000),
        this.mod(60 * 1_000).div(1_000),
        this.mod(1_000)
    )

fun stringTimeTaken(elapsedTime: Long): String {
    val (mn, s, ms) = elapsedTime.millisecondsToHMnSMs()
    return "$mn min. $s sec. $ms ms."
}

fun printReport(found: Int, totalSize: Int, searchTime: Long, sortTime: Long = 0L, stopMessage: String = "") {
    println(
        "Found $found / $totalSize entries. " +
                "Time taken: ${stringTimeTaken(sortTime + searchTime)}"
    )
    if (sortTime != 0L) {
        println("Sorting time: ${stringTimeTaken(sortTime)} $stopMessage")
        println("Searching time: ${stringTimeTaken(searchTime)}")
    }
}