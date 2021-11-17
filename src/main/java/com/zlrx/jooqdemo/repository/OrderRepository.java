package com.zlrx.jooqdemo.repository;

import com.zlrx.jooqdemo.model.OrderData;
import com.zlrx.jooqdemo.model.OrderItemData;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.zlrx.generated.tables.OrderItem.ORDER_ITEM;
import static com.zlrx.generated.tables.Orders.ORDERS;
import static org.jooq.impl.DSL.multisetAgg;

@Repository
@Transactional
public class OrderRepository {

    @Autowired
    private DSLContext dsl;

    public List<OrderItemData> findOrderItemsByOrderBatchId(int batchId) {
        return dsl.select(ORDER_ITEM.fields())
                .from(ORDER_ITEM)
                .innerJoin(ORDERS)
                .on(ORDER_ITEM.ORDER_ID.eq(ORDERS.ID))
                .where(ORDERS.BATCH_ID.eq(batchId))
                .fetchInto(OrderItemData.class);
    }

    public List<OrderData> findOrderByOrderBatchId(int batchId) {
        return dsl.select(
                        ORDERS.asterisk(),
                        multisetAgg(ORDER_ITEM.fields())
                                .convertFrom(r -> r.into(OrderItemData.class))
                )
                .from(ORDERS)
                .innerJoin(ORDER_ITEM).on(ORDERS.ID.eq(ORDER_ITEM.ORDER_ID))
                .where(ORDERS.BATCH_ID.eq(batchId))
                .groupBy(ORDERS.fields())
                .fetchInto(OrderData.class);
    }


}
