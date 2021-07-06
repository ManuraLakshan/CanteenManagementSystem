package com.canteen.Fot.repository;

import com.canteen.Fot.CanteenOwner;
import com.canteen.Fot.OrderItem;
import com.canteen.Fot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    //method to find user by email
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);



    /*@Query("SELECT a FROM User a WHERE a.email= ?1 and a.type='admin'")
    User findAdmin(String email);*/

    @Repository
    interface CanteenOwnerRepositary extends CrudRepository<CanteenOwner, Integer> {
    }


    @Query(value = "SELECT * FROM users WHERE email=:username",nativeQuery = true)
    List<User> findUserType(String username);
}
