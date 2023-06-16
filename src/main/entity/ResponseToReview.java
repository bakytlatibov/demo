package com.peaksoft.gadgetariumm5.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "responses_reviews")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseToReview {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String massage;
@OneToOne(mappedBy = "review")
    private Review review;
    @ManyToMany
    private User user;
}
