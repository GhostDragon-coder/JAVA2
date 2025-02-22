/**
 * Create fo IBS
 * @author Evgeniy Shelkunov
 */
package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main3_1 {

    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(21) - 10;
        }

        System.out.println(STR."Исходный массив: \{Arrays.toString(arr)}");

        int maxNegativeIdx = -1;
        int minPositiveIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (maxNegativeIdx == -1 || arr[i] > arr[maxNegativeIdx]) {
                    maxNegativeIdx = i;
                }
            } else if (arr[i] > 0) {
                if (minPositiveIdx == -1 || arr[i] < arr[minPositiveIdx]) {
                    minPositiveIdx = i;
                }
            }
        }

        int temp = arr[maxNegativeIdx];
        arr[maxNegativeIdx] = arr[minPositiveIdx];
        arr[minPositiveIdx] = temp;
        System.out.println(STR."Результат:      \{Arrays.toString(arr)}");
        System.out.println(STR."Макс. отрицательный: \{arr[minPositiveIdx]}");
        System.out.println(STR."Мин. положительный:  \{arr[maxNegativeIdx]}");
    }
}