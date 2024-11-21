package com.mapping.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String userName;

    @Column( unique = true)
    private String email;

    @Column(unique = true)
    private String mobile;

    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pan_card_id")
    private PanCard panCard;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aadhar_card_id")
    private AadharCard aadharCard;

}