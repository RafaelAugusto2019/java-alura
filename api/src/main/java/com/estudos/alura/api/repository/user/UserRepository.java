package com.estudos.alura.api.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserJPA,Long> {
    UserDetails findByUser(String user);
}
