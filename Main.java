/**
 * Create fo IBS
 * @author Evgeniy Shelkunov
 * @see #calculate(float, float, String)
 */
package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Задайте значение переменной x: ");
            float x = in.nextFloat();

            System.out.print("Задайте значение переменной y: ");
            float y = in.nextFloat();

            System.out.print("Введите один из символов '+', '-', '*' или '/': ");
            String operation = in.next();

            String result = calculate(x, y, operation);
            System.out.println(STR."Результат: \{result}");
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
            case "+" -> String.format("%.2f", x + y);
            case "-" -> String.format("%.2f", x - y);
            case "*" -> String.format("%.2f", x * y);
            case "/" -> {
                if (y == 0) {
                    yield "Ошибка: деление на ноль!";
                }
                yield String.format("%.2f", x / y);
            }
            default -> "Ошибка ввода! Недопустимая операция";
        };
    }
}