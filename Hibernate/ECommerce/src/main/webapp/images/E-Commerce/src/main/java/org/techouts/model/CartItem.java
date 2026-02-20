package org.techouts.model;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartItem_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "myCart_id")
    private MyCart myCart;
    @ManyToOne
    private Product product;
    private int quantity;

    public int getId() {
        return id;
    }

    public MyCart getMyCart() {
        return myCart;
    }

    public void setMyCart(MyCart myCart) {
        this.myCart = myCart;
        myCart.getCartItems().add(this);
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
