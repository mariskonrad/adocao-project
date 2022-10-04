package com.adocao.api.security.config;

import com.adocao.api.security.domain.UserAccount;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserSecurity implements UserDetails {

    private static final String PREFIX_PERMISSION_SPRING = "ROLE_";

    private final Long id;
    private final String email;
    private final String password;
    private final boolean active;
    private final List<SimpleGrantedAuthority> permissions;

    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;

    public UserSecurity(UserAccount user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.permissions = convertPermissions(user);

        this.accountNonExpired = user.isActive();
        this.accountNonLocked = user.isActive();
        this.credentialsNonExpired = user.isActive();
        this.enabled = user.isActive();
    }

    private List<SimpleGrantedAuthority> convertPermissions(UserAccount user) {
        return user.getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(PREFIX_PERMISSION_SPRING + permission.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        return this.permissions;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
