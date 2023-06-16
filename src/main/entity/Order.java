package com.peaksoft.gadgetariumm5.entity;

import com.peaksoft.gadgetariumm5.entity.enums.Delivery;
import com.peaksoft.gadgetariumm5.entity.enums.Payment;
import com.peaksoft.gadgetariumm5.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String photo;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    @ManyToOne
    @JoinTable(name = "user_id")
    private  User user;
    private Long sum;
    private  String address;
    @Enumerated(EnumType.STRING)
    private Delivery delivery;
    @Enumerated(EnumType.STRING)
    private Payment payment;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetails>orderDetails;



}
