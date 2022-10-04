package com.adocao.api.security.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Builder
@NoArgsConstructor @AllArgsConstructor
public class AccountPermission {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount username;
}
