package com.bubblesort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sort")
public class BubbleSortController {

    @Autowired
    private SortedArrayRepository sortedArrayRepository;

    @PostMapping("/bubbleSort")
    public SortedArrayResponse bubbleSort(@RequestBody List<Integer> array) {
        // Сортировка пузырьком
        int[] arrayToSort = array.stream().mapToInt(i -> i).toArray();
        bubbleSortAlgorithm(arrayToSort);

        // Генерация уникального идентификатора для сортировки
        Long sortId = System.currentTimeMillis(); // используем время как уникальный идентификатор для сортировки

        // Сохранение результата в базе данных
        for (int value : arrayToSort) {
            sortedArrayRepository.save(new SortedArray(value, sortId));  // Применение нового конструктора
        }

        // Возвращаем результат в виде объекта с ID сортировки и отсортированным массивом
        List<Integer> sortedList = Arrays.stream(arrayToSort).boxed().collect(Collectors.toList());
        return new SortedArrayResponse(sortId, sortedList);
    }

    // Алгоритм пузырьковой сортировки
    private void bubbleSortAlgorithm(int[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Получение отсортированного массива по sortId
    @GetMapping("/result/{sortId}")
    public ResponseEntity<Object> getSortedArrayResult(@PathVariable Long sortId) {
        List<SortedArray> result = sortedArrayRepository.findBySortId(sortId);

        if (result.isEmpty()) {
            // Если данных по указанному sortId нет, возвращаем ошибку 404 с сообщением
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Результат сортировки с данным ID не найден.");
        }

        return ResponseEntity.ok(result);
    }
}
