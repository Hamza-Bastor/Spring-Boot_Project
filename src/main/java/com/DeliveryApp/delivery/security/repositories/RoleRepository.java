package com.DeliveryApp.delivery.security.repositories;

import com.DeliveryApp.delivery.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
