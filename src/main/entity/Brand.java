package com.peaksoft.gadgetariumm5.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
@Getter
@Setter
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @JoinColumn(name = "brand_name")
    private  String brandName;
@OneToMany
    private List<Product>products;

}
