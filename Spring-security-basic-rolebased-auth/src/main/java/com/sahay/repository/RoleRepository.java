package com.sahay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahay.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
