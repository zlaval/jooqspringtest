package com.zlrx.jooqdemo.repository;

import com.zlrx.jooqdemo.model.OrderItemData;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.zlrx.generated.tables.OrderItem.ORDER_ITEM;
import static com.zlrx.generated.tables.Orders.ORDERS;

@Repository
@Transactional
public class OrderRepository {

    @Autowired
    private DSLContext dsl;

    public List<OrderItemData> findByBatchId(int batchId) {

        return dsl.select(ORDER_ITEM.fields())
                .from(ORDER_ITEM)
                .innerJoin(ORDERS)
                .on(ORDER_ITEM.ORDER_ID.eq(ORDERS.ID))
                .where(ORDERS.BATCH_ID.eq(batchId))
                .fetchInto(OrderItemData.class);
    }


}
