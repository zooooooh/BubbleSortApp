package com.bubblesort;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081") // Убедитесь, что это правильный адрес фронтенда
public class BubbleSortController {

    @PostMapping("/sort")
    public int[] sortArray(@RequestBody int[] array) {
        return bubbleSort(array);
    }

    // Метод сортировки пузырьком
    private int[] bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Временная переменная для обмена
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
