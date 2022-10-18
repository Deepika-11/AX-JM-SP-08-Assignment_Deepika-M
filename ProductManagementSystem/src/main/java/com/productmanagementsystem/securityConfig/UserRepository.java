package com.productmanagementsystem.securityConfig;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByUserName(String userName);
}
