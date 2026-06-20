package com.cg.model;

import com.cg.dto.AddressResponse;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

//    @Column(name = "address")
//    AddressResponse addressResponse;

}
