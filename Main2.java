/**
 * Create fo IBS
 * @author Evgeniy Shelkunov
 * @see #calculate(float, float, String)
 * @see #stringArray(String[])
 */
package org.example;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                System.out.print("Введите номер задания: (1 - калькулятор, 2 - поиск максимального слова в массиве, 0 - выход)\n>>> ");
                int choice = in.nextInt();
                in.nextLine();

                if (choice == 0) break;

                switch (choice) {
                    case 1:
                        System.out.print("Задайте значение переменной x: ");
                        float x = in.nextFloat();

                        System.out.print("Задайте значение переменной y: ");
                        float y = in.nextFloat();

                        System.out.print("Введите один из символов '+', '-', '*' или '/': ");
                        String operation = in.next();

                        String result = calculate(x, y, operation);
                        System.out.println(STR."Результат: \{result}");
                        break;
                    case 2:
                        System.out.print("Задайте размер массива: ");
                        int arrayLength = in.nextInt();
                        in.nextLine();

                        String[] myArray = new String[arrayLength];

                        for (int i = 0; i < arrayLength; i++) {
                            System.out.print(STR."Введите значение для элемента №\{i + 1} в массиве: ");
                            String myStr = in.nextLine();
                            myArray[i] = myStr;
                        }

                        String maxWord = stringArray(myArray);
                        System.out.println(STR."Самое длинное слово: \{maxWord}");
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     *
     * @param x input value
     * @param y input value
     * @param operation input value
     * @return string value
     */
    public static String calculate(float x, float y, String operation) {
        return switch (operation) {
            case "+" -> String.format("%.4f", x + y);
            case "-" -> String.format("%.4f", x - y);
            case "*" -> String.format("%.4f", x * y);
            case "/" -> {
                if (y == 0) {
                    yield "Ошибка: деление на ноль!";
                }
                yield String.format("%.4f", x / y);
            }
            default -> "Ошибка ввода! Недопустимая операция";
        };
    }

    /**
     *
     * @param arr input value
     * @return string value
     */
    public static String stringArray(String[] arr) {
        if (arr == null || arr.length == 0) return "Нет данных";
        String maxWord = arr[0];
        for (String word : arr) {
            if (word.length() > maxWord.length()) {
                maxWord = word;
            }
        }
        return maxWord;
    }
}