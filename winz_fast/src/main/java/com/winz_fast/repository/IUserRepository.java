package com.winz_fast.repository;

import com.winz_fast.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Users, Long> {
}
