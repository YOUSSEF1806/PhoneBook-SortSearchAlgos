import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    val dataSetFile = File("directory.txt")
    val searchSetFile = File("find.txt")
    val dataSet = readDataSetFile(dataSetFile)
    val searchSet = readDataSetFile(searchSetFile)

    var found = 0

    // Linear Search Process
    var searchTime = measureTimeMillis {
        println("Start searching (linear search) ...")
        found = searchSet.count { string ->
            dataSet.map { it.getFullName() }.contains(string.trim())
        }
    }
    printReport(found, searchSet.size, searchTime)

    var sortedData = dataSet.toMutableList()
    var sortTime: Long

    // Bubble Sort and Jump Search Process
    println("Start searching (bubble sort + jump search) ...")
    bubbleSort(sortedData, searchTime * 10).run {
        sortedData = this.first
        sortTime = this.second
    }
    var stopMessage = ""
    searchTime = measureTimeMillis {
        found = if (sortedData.isNotEmpty()) {
            searchSet.count { jumpSearch(sortedData, it) != -1 }
        } else {
            stopMessage = "STOPPED, moved to linear search"
            searchSet.count { value ->
                dataSet.map { it.getFullName() }.contains(value.trim())
            }
        }
    }
    printReport(found, searchSet.size, searchTime, sortTime, stopMessage)

    sortedData = dataSet.toMutableList()

    // Quick Sort and Binary Search Process
    println("Start searching (quick sort + binary search) ...")
    sortTime = measureTimeMillis {
        sortedData = quickSort(sortedData)
    }
    searchTime = measureTimeMillis {
        found = searchSet.count { binarySearch(sortedData, it) != -1 }
    }
    printReport(found, searchSet.size, searchTime, sortTime)

    // Hash table sorting and search
    println("Start searching (hash table)...")
    var hashMap = HashMap<String, String>()
    sortTime = measureTimeMillis {
        hashMap = HashMap<String, String>(
            dataSet.associate {
                it.substringAfter(" ") to it.substringBefore(" ")
            }
        )
    }
    searchTime = measureTimeMillis {
        found = searchSet.count { hashMap.containsKey(it.trim()) }
    }
    println(
        "Found $found / ${searchSet.size} entries. " +
                "Time taken: ${stringTimeTaken(sortTime + searchTime)}"
    )
    println("Creating time: ${stringTimeTaken(sortTime)}")
    println("Searching time: ${stringTimeTaken(searchTime)}")
}
