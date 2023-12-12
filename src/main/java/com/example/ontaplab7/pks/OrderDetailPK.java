package com.example.ontaplab7.pks;


import com.example.ontaplab7.models.Order;
import com.example.ontaplab7.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter @Getter
public class OrderDetailPK implements Serializable {
    private Order order;
    private Product product;
}
