package com.bubblesort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortedArrayController {

    @Autowired
    private SortedArrayRepository sortedArrayRepository;

    // Создание нового элемента
    @GetMapping("/add")
    public String add(@RequestParam Long sortId, @RequestParam int value) {
        SortedArray item = new SortedArray(value, sortId);
        sortedArrayRepository.save(item);
        return "Data saved";
    }
}