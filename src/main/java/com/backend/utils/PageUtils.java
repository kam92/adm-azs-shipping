package com.backend.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PageUtils {

    private PageUtils(){}
    public static <T> Page<T> createPage(List<T> content, Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), content.size());

        return new PageImpl<>(content.subList(start, end), pageable, content.size());
    }
}