package org.openpredict.exchange.rest.commands;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.openpredict.exchange.beans.OrderAction;
import org.openpredict.exchange.beans.OrderType;

import java.math.BigDecimal;

@Getter
public final class RestApiPlaceOrder {

    private final long orderId;

    private final BigDecimal price;
    private final long size; // only integer sizes allowed

    private final long userCookie;
    private final OrderAction action;
    private final OrderType orderType;

    @JsonCreator
    public RestApiPlaceOrder(
            @JsonProperty("orderId") long orderId,
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("size") long size,
            @JsonProperty("userCookie") long userCookie,
            @JsonProperty("action") OrderAction action,
            @JsonProperty("orderType") OrderType orderType) {

        this.orderId = orderId;
        this.price = price;
        this.size = size;
        this.userCookie = userCookie;
        this.action = action;
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "[ADD " + (action == OrderAction.ASK ? 'A' : 'B') + orderType
                + price + ":" + size + "]";
    }
}
