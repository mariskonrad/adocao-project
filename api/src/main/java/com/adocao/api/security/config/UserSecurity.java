package com.adocao.api.security.config;

import com.adocao.api.security.domain.UserAccount;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserSecurity implements UserDetails {

    private final Long id;
    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;

    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;

    public UserSecurity(UserAccount user) {

        this.id = user.getId();
        this.username = user.getEmail();
        this.password = user.getPassword();

        this.accountNonExpired = user.isActive();
        this.accountNonLocked = user.isActive();
        this.credentialsNonExpired = user.isActive();
        this.enabled = user.isActive();

        this.authorities = user.getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getRole().getRole()))
                .collect(Collectors.toList());
    }
}
