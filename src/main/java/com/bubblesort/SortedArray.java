package com.bubblesort;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SortedArray {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer arrayValue;  // Переименовано в arrayValue

    private Long sortId;

    // Конструктор без параметров
    public SortedArray() {
    }

    // Конструктор с параметрами
    public SortedArray(Integer arrayValue, Long sortId) {
        this.arrayValue = arrayValue;
        this.sortId = sortId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getArrayValue() {
        return arrayValue;
    }

    public void setArrayValue(Integer arrayValue) {
        this.arrayValue = arrayValue;
    }

    public Long getSortId() {
        return sortId;
    }

    public void setSortId(Long sortId) {
        this.sortId = sortId;
    }
}
