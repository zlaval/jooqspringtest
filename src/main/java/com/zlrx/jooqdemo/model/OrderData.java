package com.zlrx.jooqdemo.model;

import java.time.LocalDateTime;
import java.util.List;

public record OrderData(
        Integer id,
        Integer batchId,
        LocalDateTime created,
        String username,
        List<OrderItemData> orderItems
) {
}
