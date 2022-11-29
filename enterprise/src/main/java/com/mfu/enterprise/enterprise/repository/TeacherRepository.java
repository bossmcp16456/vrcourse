package com.mfu.enterprise.enterprise.repository;

import com.mfu.enterprise.enterprise.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@EnableJpaRepositories
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findById(long id);
}