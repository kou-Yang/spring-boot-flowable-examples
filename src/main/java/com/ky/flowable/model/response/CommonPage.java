package com.ky.flowable.model.response;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author ky
 * @description
 * @date 2024-04-25 21:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonPage<T> {

    private List<T> record;
    private Long total;

    public static <T> CommonPage<T> restPage(List<T> list, Long total) {
        return new CommonPage<T>(list, total);
    }

    public static <T> CommonPage<T> restPage(IPage<T> page) {
        return new CommonPage<T>(page.getRecords(), page.getTotal());
    }

    public static <T> CommonPage<T> emptyPage() {
        return new CommonPage<T>(Collections.emptyList(), 0L);
    }
}
