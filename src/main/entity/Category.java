package com.peaksoft.gadgetariumm5.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sub_categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String title;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private List<Subcategory> subcategories;
  @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,})
  @JoinTable(name = "categories_products",
  joinColumns = @JoinColumn(name = "category_id"),
          inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product>products;

}
