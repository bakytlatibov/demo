package com.peaksoft.gadgetariumm5.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String photo;
    @ManyToMany()
    private List<Product> product;
    private  String commentary;
    private  int rade;
   @ ManyToMany
    @JoinTable(name = "reviews_response_reviews",
    joinColumns = @JoinColumn(name = "reviews_id"),
    inverseJoinColumns = @JoinColumn(name = "response_review_I"))
    private List<ResponseToReview> review;
    @ManyToMany
    private  List<User>users;
}
