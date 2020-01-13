import java.lang.StringBuilder
import java.util.*

/**
 * Created by User on 13 Янв., 2020
 */

fun main(){
    val symbList = arrayOf("Х", "Е", "К", "Р", "С", "У", "А", "Н", "О", "М", "Т", "В")
    val numbers = ArrayList<String>()


    var start = System.currentTimeMillis()
    for (symb1 in symbList){
        for (i in 1..198){
            for (j in 0..999){
                for (symb2 in symbList){
                    val builder = StringBuilder();
                    builder.append(symb1)
                    if (j < 10) {
                        builder.append("00$j")
                    } else if (j in 9..100)
                    {
                        builder.append((j % 10).toString() + j.toString())
                    } else if (j % 10 == j / 100 || j % 100 == 0) {
                        builder.append(j)
                    } else
                        continue
                    builder.append(symb2)
                    builder.append(symb1)
                    if (i < 10){
                        builder.append("0")
                    }
                    builder.append(i)
                    val output = builder.toString()
                    numbers.add(output)
//                    println(output)
                }
            }
        }
    }
    println("Заполнение листа в " + numbers.size + " = " + (System.currentTimeMillis() - start))

    val hashSet = HashSet<String>()
    hashSet.addAll(numbers)

    val treeSet = TreeSet<String>()
    treeSet.addAll(numbers)

    do {
        val input = readLine()
        if (input == null){
            continue
        }
        var sMess = "Прямой перебор"
        start = System.nanoTime()
        println(numbers.contains(input))
        println(sMess + " = " + (System.nanoTime() - start))

        sMess = "Бинарный поиск"
        Collections.sort(numbers)
        start = System.nanoTime()
        println(Collections.binarySearch(numbers, input))
        println(sMess + " = " + (System.nanoTime() - start))

        sMess = "HashSet"
        start = System.nanoTime()
        println(hashSet.contains(input))
        println(sMess + " = " + (System.nanoTime() - start))

        sMess = "TreeSet"
        start = System.nanoTime()
        println(treeSet.contains(input))
        println(sMess + " = " + (System.nanoTime() - start))
        if (input.compareTo("exit") != 0) {
            break
        }
    } while (true)
}

