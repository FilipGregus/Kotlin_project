import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun parseCSV(filePath: String): List<List<String>> {
    val data: MutableList<List<String>> = mutableListOf()

    try {
        val file = File(filePath)
        val bufferedReader = BufferedReader(FileReader(file))

        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            val values = line!!.split(",") // assuming CSV file uses comma as delimiter
            data.add(values)
        }

        bufferedReader.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return data
}
fun main(args: Array<String>)
{
    val path = "strava.csv"

    val x = parseCSV(path)
    println(x[0][10])
}