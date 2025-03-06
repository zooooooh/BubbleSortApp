package com.bubblesort;

import java.util.List;

public class SortedArrayResponse {
    private Long sortId;
    private List<Integer> sortedArray;

    public SortedArrayResponse(Long sortId, List<Integer> sortedArray) {
        this.sortId = sortId;
        this.sortedArray = sortedArray;
    }

    public Long getSortId() {
        return sortId;
    }

    public void setSortId(Long sortId) {
        this.sortId = sortId;
    }

    public List<Integer> getSortedArray() {
        return sortedArray;
    }

    public void setSortedArray(List<Integer> sortedArray) {
        this.sortedArray = sortedArray;
    }
}
