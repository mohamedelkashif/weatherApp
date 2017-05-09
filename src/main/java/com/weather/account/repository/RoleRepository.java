package com.weather.account.repository;

import com.weather.account.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * @author Mohamed Elkashif
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
}
