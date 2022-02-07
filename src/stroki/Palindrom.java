package stroki;
//
//  Написать метод проверяющий является ли введенное слово или фраза палиндромом
//  Игнорируя пробелы в фразе и размер букв
//  Написать 3 варианта метода:
//  1) простой через циклы
//  2) через StringBuilder
//  3) Через рекурсию


public class Palindrom {
    public static String isPalindromRecursion(String str) {
        if (str.length() == 1) {
            return "YES";
        } else {
            if (str.substring(0, 1).equals(str.substring(str.length() - 1, str.length()))) {
                if (str.length() == 2) {
                    return "YES";
                }
                return isPalindromRecursion(str.substring(1, str.length() - 1));
            } else {
                return "NO";
            }
        }
    }

    public static String isPalindromBasic(String str){
        char[] array = str.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }
        return result.equals(str)?"YES":"NO";

    }

    public static String isPalindromBuilder(String str){
        return str.equals(new StringBuilder(str).reverse().toString())?"YES":"NO";
    }

    public static String clearString(String str){
        return str.toLowerCase().replace(" ","");
    }

    public static void main(String[] args) {
        System.out.println(isPalindromRecursion(clearString("ABBA")));
        System.out.println(isPalindromBuilder(clearString("ABBA")));
        System.out.println(isPalindromBasic(clearString("ABBA")));
    }
}
