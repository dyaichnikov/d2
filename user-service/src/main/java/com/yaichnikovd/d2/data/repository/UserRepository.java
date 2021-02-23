package com.yaichnikovd.d2.data.repository;

import com.yaichnikovd.d2.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
