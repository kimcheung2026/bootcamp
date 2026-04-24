package com.project.datingapp.repository;

import java.util.Optional;

import com.project.datingapp.entity.UserPreference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {
  Optional<UserPreference> findByUserId(Long userId);
}