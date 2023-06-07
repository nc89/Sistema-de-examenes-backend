package com.exams.system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class UserRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRol;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne
    private Rol rol;

    public UserRol() {
    }

    public UserRol(Long userRol, User user, Rol rol) {
        this.userRol = userRol;
        this.user = user;
        this.rol = rol;
    }
}
