package com.shopping.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shopping.entities.Role;
import com.shopping.entities.Roles;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByRoleName(Roles role);
}
