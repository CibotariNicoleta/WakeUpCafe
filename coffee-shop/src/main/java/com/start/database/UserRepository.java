package com.start.database;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.start.loginAndRegistration.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
     User findByEmail(String email);
}
