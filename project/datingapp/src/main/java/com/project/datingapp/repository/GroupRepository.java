package com.project.datingapp.repository;

import com.project.datingapp.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByUsername(String username);
}