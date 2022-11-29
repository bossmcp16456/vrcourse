package com.mfu.enterprise.enterprise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mfu.enterprise.enterprise.model.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findById(long id);
}