package com.peaksoft.gadgetariumm5.entity;

import com.peaksoft.gadgetariumm5.entity.enums.BodyShape;
import com.peaksoft.gadgetariumm5.entity.enums.Gender;
import com.peaksoft.gadgetariumm5.entity.enums.WaterResistance;
import com.peaksoft.gadgetariumm5.entity.enums.WirelessInterfaces;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photo;
    @ManyToOne
    private Brand brand;
    private String name;
    private String article;
    private int price;
    private String screen;
    private String color;
    private String rating;
    private String memory;
    @ManyToOne()
    private Category category;
    @JoinColumn(name = "release_date")
    private LocalDate releaseDate;
    @JoinColumn(name = "operating_system")
    private String operatingSystem;
    @JoinColumn(name = "sim_card")
    private int simCard;
    private int warranty;
    private String processor;
    private int weight;
    @Enumerated(EnumType.STRING)
    private WirelessInterfaces wirelessInterfaces;
    @Enumerated(EnumType.STRING)
    private WaterResistance waterResistance;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private BodyShape bodyShape;
    @ManyToMany
    @JoinTable(name = "products_review",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "review_id"))
    private List<Review> reviews;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "products_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    private Bucked bucked;
}
