package com.mapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AadharCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column( unique = true)
    private String aadharNumber;

    @Column(unique = true)
    private String vidNumber;

    @OneToOne
    @JsonIgnore
    private User user;

}