
fun quickSort(
    dataSet: MutableList<String>,
    leftIndex: Int = 0,
    rightIndex: Int = dataSet.lastIndex
): MutableList<String> {
    if (leftIndex < rightIndex) {
        val pivotIndex = pivotPart(dataSet, leftIndex, rightIndex)
        quickSort(dataSet, leftIndex, pivotIndex - 1)
        quickSort(dataSet, pivotIndex + 1, rightIndex)
    }
    return dataSet
}

fun pivotPart(
    data: MutableList<String>,
    leftIndex: Int,
    rightIndex: Int
): Int {
    val pivot = data[rightIndex]
    var i = leftIndex - 1
    for (j in leftIndex..<rightIndex) {
        if (data[j].getFullName() < pivot.getFullName()) {
            i++
            data.swap(i, j)
        }
    }
    data.swap(i + 1, rightIndex)
    return i + 1
}