package com.peaksoft.gadgetariumm5.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "buckeds")
@Getter
@Setter
public class Bucked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  Long amount;
    private int discount;
    private  int total;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.DETACH},mappedBy = "bucked")
    @JoinTable(name = "bucked_product",
            joinColumns = @JoinColumn(name = "backed_id"),
           inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

}
