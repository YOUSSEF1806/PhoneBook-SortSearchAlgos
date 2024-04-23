
fun bubbleSort(dataSet: MutableList<String>, timeLimit: Long): Pair<MutableList<String>, Long> {
    var processTime: Long = 0
    var swapped = true
    val startTime = System.currentTimeMillis()
    while (swapped) {
        swapped = false
        for (i in (1..<dataSet.size)) {
            if (dataSet[i - 1].getFullName() > dataSet[i].getFullName()) {
                dataSet.swap(i - 1, i)
                swapped = true
            }
        }
        processTime += System.currentTimeMillis() - startTime
        if (processTime > timeLimit)
            return Pair(mutableListOf(), processTime)
    }
    return Pair(dataSet, processTime)
}