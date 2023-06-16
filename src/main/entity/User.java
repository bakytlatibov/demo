package com.peaksoft.gadgetariumm5.entity;

import com.peaksoft.gadgetariumm5.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    @JoinColumn(name = "lasts_name")
    private  String lastName;
    private String email;
    @JoinColumn(name="phone_number")
    private  String phoneNumber;
    private String address;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Bucked bucked;
     @ManyToMany
    private List<Review>reviews;
     @ManyToMany
    private List<ResponseToReview>responseToReviews;



}
