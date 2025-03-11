package com.shosha.springboot.demo.jopportal.util;

import com.shosha.springboot.demo.jopportal.entity.Users;
import com.shosha.springboot.demo.jopportal.entity.UsersType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The type Custom user details.
 */
public class CustomUserDetails implements UserDetails {
    private final Users user;

    /**
     * Instantiates a new Custom user details.
     *
     * @param user the user
     */
    public CustomUserDetails(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        UsersType usersType = user.getUserTypeId();
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(usersType.getUserTypeName()));
        return authorityList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();

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

    @Override
    public boolean isEnabled() {
        return true;
    }
}
