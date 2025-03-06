package com.bubblesort;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SortedArrayRepository extends JpaRepository<SortedArray, Long> {
    List<SortedArray> findBySortId(Long sortId);
}
