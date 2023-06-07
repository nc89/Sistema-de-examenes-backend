package com.exams.system.model;

import com.exams.system.model.jwt.Authority;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter @Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private String cellphone;
    private boolean enabled = true;
    private String profile;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    @JsonIgnore
    private Set<UserRol> userRoles = new HashSet<>();

    public User(){}

    public User(Long id, String username, String password, String name, String lastname, String email, String cellphone, boolean enabled, String profile, Set<UserRol> userRoles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.cellphone = cellphone;
        this.enabled = enabled;
        this.profile = profile;
        this.userRoles = userRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> authoritys = new HashSet<>();
        this.userRoles.forEach(userRol -> {
            authoritys.add(new Authority(userRol.getRol().getNameRol()));
        });
        return authoritys;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
