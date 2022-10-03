package com.adocao.api.security.repository;

import com.adocao.api.security.domain.Username;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Username, Long> {

    Optional<Username> findByEmail(String email);
}
