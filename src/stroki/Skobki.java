package stroki;

public class Skobki {
//
//    Постановка задачи: Необходимо написать метод,который выполняет валидацию строки.
//    Если , строка состоит из скобок составленных по математическим правилам , то результат выполнения функции успех
//
//    Идушие друг за другом блоки "()" должны быть заключены в общий блок "()" если не заключены то неуспех
//    Допустимые символы в строке "()"
//    Наличие любых других символов считаем ошибкой входящих параметров. Примеры
//
//      (), (()), (()()), (()()()) - успешно
//
//      (, ) , )(, ((), ()), ()(, ()(), ())(() - неуспешно

//    Вариант 2:
//    Постановка задачи: Написать метод, который выполняет валидацию расстановки двух типов скобок "()" и "[]"
//    Причем блоки "[]" можно вкладывать в блоки "()" но не наоборот
//    Любой символ в исходных данных не являющийся одним из "()[]" означает неправильные входные данные
//    Если два блока скобок идут друг за другом они все вместе должны быть обернуты "()" иначе строка считается неправильной.
//    для решения задачи нельзя пользоваться коллекциями!!!
//    Примеры:
//    ([])      -   true
//    ()[]      -   false
//    (()[])    -   true
//    (([)])    -   false
//    ([()])    -   false
//    (([]))    -   true
//    (([][]))  -   true
//    ([(][]))  -   false
//    ()        -   true
//    ()()      -   false
//    []        -   true
//    [][]      -   false
//    (([])([]))-   true
//    ([])([])  -   false



    public static void main(String[] args) {
        System.out.println(check("()"));
        System.out.println(check("(())"));
        System.out.println(check("(()())"));
        System.out.println(check("(()()())"));
        System.out.println(check("("));
        System.out.println(check(")"));
        System.out.println(check(")("));
        System.out.println(check("(()"));
        System.out.println(check("())"));
        System.out.println(check("()()"));
        System.out.println(check("())(()"));
        System.out.println(check2("([])")); //true
        System.out.println(check2("()[]")); //false два блока подряд без оберточного блока
        System.out.println(check2("(()[])")); //true
        System.out.println(check2("(([)])")); //false в квадратные скобки нельзя вкладывать круглые
        System.out.println(check2("([()])")); //false в квадратные скобки нельзя вкладывать круглые
        System.out.println(check2("(([]))")); //true
        System.out.println(check2("(([][]))")); //true
        System.out.println(check2("([(][]))")); //false в квадратные скобки нельзя вкладывать круглые
        System.out.println(check2("()")); //true
        System.out.println(check2("[]")); //true
        System.out.println(check2("[][]")); //false два блока подряд без оберточного блока
        System.out.println(check2("(([])([]))")); //true
        System.out.println(check2("([])([])")); //true
        System.out.println(check2("()()")); //false два блока подряд без оберточного блока
        System.out.println(check2("([][])")); //true
    }

    public static boolean check(String stroka) {
        if (stroka == null || stroka.isEmpty()) {
            return false;
        }
        System.out.print(stroka + "  -  ");
        if (stroka.length() % 2 != 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < stroka.length(); i++) {
            if (stroka.charAt(i) != '(' && stroka.charAt(i) != ')') {
                return false;
            }
            if (stroka.charAt(i) == '(') {
                count++;
            }
            if (stroka.charAt(i) == ')') {
                if (count == 0) {
                    return false;
                }
                count--;
            }
            if (count == 0 && i < stroka.length() - 1) {
                return false;
            }
        }
        return count == 0;
    }

//    public static Boolean check(String text) {
//        Pattern pattern = Pattern.compile("\\([\\d+/*-]*\\)");
//        Matcher matcher = pattern.matcher(text);
//        do {
//            text = matcher.replaceAll("");
//            matcher = pattern.matcher(text);
//        } while (matcher.find());
//        return text.matches("[\\d+/*-]*");
//    }

    public static boolean check2(String stroka) {
        System.out.print(stroka + "  -  ");
        if (stroka == null || stroka.isEmpty()) {
            return false;
        }
        if (stroka.length() % 2 != 0) return false;
        int countBracketsType1 = 0;
        int countBracketsType2 = 0;
        for (int i = 0; i < stroka.length(); i++) {
            if (stroka.charAt(i) != '(' && stroka.charAt(i) != ')' && stroka.charAt(i) != '[' && stroka.charAt(i) != ']') {
                return false;
            }
            if (stroka.charAt(i) == '(') {
                if (countBracketsType2 != 0) {
                    return false;
                }
                countBracketsType1++;
            }
            if (stroka.charAt(i) == '[') {
                countBracketsType2++;
            }
            if (stroka.charAt(i) == ')') {
                if (countBracketsType1 == 0) {
                    return false;
                }
                if (countBracketsType2 != 0) {
                    return false;
                }
                countBracketsType1--;
            }
            if (stroka.charAt(i) == ']') {
                if (countBracketsType2 == 0) {
                    return false;
                }
                countBracketsType2--;
            }
            if (countBracketsType1 == 0 && countBracketsType2 == 0 && i < stroka.length() - 1) {
                return false;
            }
        }
        return countBracketsType1 == 0 && countBracketsType2 == 0;
    }

}
