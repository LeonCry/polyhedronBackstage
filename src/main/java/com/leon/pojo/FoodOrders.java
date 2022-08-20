package com.leon.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrders {
    private int orderId;
    private String orderPerson;
    private int orderDiners;
    private String orderContent;
    private String orderStatus;
    private Long orderTime;
}
