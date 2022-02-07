package stroki


fun main() {
    println(check("()"))
    println(check("(())"))
    println(check("(()())"))
    println(check("(()()())"))
    println(check("("))
    println(check(")"))
    println(check(")("))
    println(check("(()"))
    println(check("())"))
    println(check("()()"))
    println(check("())(()"))
}

fun check(stroka: String): Boolean {
    if (stroka.isEmpty()) {
        return false
    }
    print("$stroka  -  ")
    if (stroka.length % 2 != 0) {
        return false
    }
    var count = 0

    for (c in stroka.indices) {
        when (stroka[c]) {
            '(' -> count ++
            ')' -> {
                if(count==0) return false;
                count--
            }
            else -> return false;
        }
        if (count == 0 && c < stroka.length - 1) {
            return false
        }
    }
    return count == 0
}