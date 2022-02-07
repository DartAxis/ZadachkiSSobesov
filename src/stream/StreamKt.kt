package stream

import java.util.*
import java.util.stream.Stream

// Постановка задачи: Вывести на экран сколько раз цифра 9 встречается в ряду чисел от 1 до 100
// 1) стримом
// 2) без стрима

fun main() {

    // 1-й вариант
    println(Stream.iterate(1) { x: Int -> x + 1 }
        .limit(100)
        .map { obj: Int? -> java.lang.String.valueOf(obj) }
        .flatMap { p: String ->
            Arrays.stream(
                p.split("".toRegex()).toTypedArray()
            )
        }
        .filter { s: String -> s.contains("9") }
        .count())
    //2-й вариант
    var count = 0
    for (i in 0..99) {
        if (i % 10 == 9) {
            count++
        }
        if (i / 10 == 9) {
            count++
        }
    }
    println(count)
}