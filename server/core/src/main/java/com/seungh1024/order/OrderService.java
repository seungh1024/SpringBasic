package com.seungh1024.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
