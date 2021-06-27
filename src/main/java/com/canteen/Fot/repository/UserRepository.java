package com.canteen.Fot.repository;

import com.canteen.Fot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {
    //method to find user by email
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

    /*@Query("SELECT a FROM User a WHERE a.email= ?1 and a.type='admin'")
    User findAdmin(String email);*/
}
