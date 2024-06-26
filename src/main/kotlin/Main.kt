import java.io.BufferedReader
import java.io.File
import java.io.FileReader
fun parseCSV(filePath: String, drop: Int, trim:Boolean): List<List<String>> {
    val data: MutableList<List<String>> = mutableListOf()
    var counter:Int = 0

    try {
        val file = File(filePath)
        val bufferedReader = BufferedReader(FileReader(file))
        var dropLines = drop

        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            val values = line!!.split(",") // assuming CSV file uses comma as delimiter
            if(dropLines >= 0){
                dropLines--
            } else{
                if ((trim && line!!.isNotEmpty()) || !trim) {
                    val values = line!!.split(",") // assuming CSV file uses comma as delimiter
                    data.add(values)
                    counter++
                }
            }
        }
        println("$counter lines loaded..")
        bufferedReader.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return data
}

fun writeNames(): Unit
{
    println("Filip Gregus")
    println("Gabriel Galbavy")
}

fun main(args: Array<String>)
{
    val path = "strava.csv"
    val drop: Int = 1

    val x = parseCSV(path, drop, false)
    x.forEach{ println(it)}
    writeNames()
}