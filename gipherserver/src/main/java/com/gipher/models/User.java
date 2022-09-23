package com.gipher.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users")
@Data


public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private boolean enabled=true;

    public User() {
        super();
    }

    public User(Long id, String password, String firstname, String lastname, String email, String phone, boolean enabled) {
        super();
        this.id = id;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public String getUsername() {
        return email;
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
