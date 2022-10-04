package com.adocao.api.security.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
@Builder
@AllArgsConstructor @NoArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private boolean active;

    @OneToMany(mappedBy = "username", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AccountPermission> permissions = new ArrayList<>();

    public void addPermission(AccountPermission permission) {
        this.permissions.add(permission);
        permission.setUsername(this);
    }
}

