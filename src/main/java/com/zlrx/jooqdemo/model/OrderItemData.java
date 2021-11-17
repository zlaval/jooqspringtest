package com.zlrx.jooqdemo.model;

import java.time.LocalDateTime;

public record OrderItemData(
        Integer id,
        Integer orderId,
        LocalDateTime created,
        String name
) {
}
