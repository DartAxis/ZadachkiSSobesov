package stream;

import java.util.Arrays;
import java.util.stream.Stream;

// Постановка задачи: Вывести на экран сколько раз цифра 9 встречается в ряду чисел от 1 до 100
// 1) стримом
// 2) без стрима

public class StreamZad {
    public static void main(String[] args) {
        // 1-й вариант
        System.out.println(Stream.iterate(1, x -> x + 1)
                .limit(100)
                .map(String::valueOf)
                .flatMap(p -> Arrays.stream(p.split("")))
                .filter(s -> s.contains("9"))
                .count());
        //2-й вариант
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 9) {
                count++;
            }
            if (i / 10 == 9) {
                count++;
            }
        }
        System.out.println(count);
    }
}
