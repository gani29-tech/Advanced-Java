package com.techouts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "My_cart")
public class MyCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "myCart", cascade = CascadeType.ALL)
    private List<CartItem> items;
    private int totalPrice;
    @OneToOne
    private User user;
}
