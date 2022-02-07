package stroki

import java.util.*

//
//  Написать метод проверяющий является ли введенное слово или фраза палиндромом
//  Игнорируя пробелы в фразе и размер букв
//  Написать 3 варианта метода:
//  1) простой через циклы
//  2) через StringBuilder
//  3) Через рекурсию

fun isPalindromRecursion(str: String): String? {
    return if (str.length == 1) {
        "YES"
    } else {
        if (str.substring(0, 1) == str.substring(str.length - 1, str.length)) {
            if (str.length == 2) {
                "YES"
            } else isPalindromRecursion(str.substring(1, str.length - 1))
        } else {
            "NO"
        }
    }
}

fun isPalindromBasic(str: String): String? {
    val array = str.toCharArray()
    var result = ""
    for (i in array.indices.reversed()) {
        result += array[i]
    }
    return if (result == str) "YES" else "NO"
}

fun isPalindromBuilder(str: String): String? {
    return if (str == StringBuilder(str).reverse().toString()) "YES" else "NO"
}

fun clearString(str: String): String {
    return str.lowercase(Locale.getDefault()).replace(" ", "")
}


fun main() {
    println(isPalindromRecursion(clearString("ABBA")))
    println(isPalindromBuilder(clearString("ABBA")))
    println(isPalindromBasic(clearString("ABBA")))
}