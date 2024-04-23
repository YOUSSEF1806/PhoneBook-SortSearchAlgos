
fun binarySearch(
    sortedData: List<String>,
    value: String,
    leftIndex: Int = 0,
    rightIndex: Int = sortedData.lastIndex
): Int {
    if ( (rightIndex - leftIndex) <= 2 ) {
        for (i in leftIndex .. rightIndex) {
            if (sortedData[i].getFullName() == value.trim())
                return i
        }
        return -1
    }
    val middle = (rightIndex + leftIndex) / 2
    if (sortedData[middle].getFullName() == value.trim())
        return middle
    else if (sortedData[middle].getFullName() > value.trim()) {
        return binarySearch(sortedData, value, leftIndex, middle-1)
    } else
        return binarySearch(sortedData, value, middle+1, rightIndex)
}