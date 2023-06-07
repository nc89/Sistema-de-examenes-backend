package com.exams.system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter @Setter
public class Rol {
    @Id
    private Long rolId;
    private String nameRol;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "rol")
    private Set<UserRol> userRoles = new HashSet<>();

    public Rol() {
    }

    public Rol(Long rolId, String name, Set<UserRol> userRoles) {
        this.rolId = rolId;
        this.nameRol = name;
        this.userRoles = userRoles;
    }
}
