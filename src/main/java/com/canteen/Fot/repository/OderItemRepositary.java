package com.canteen.Fot.repository;

<<<<<<< HEAD:src/main/java/com/canteen/Fot/OderItemRepositary.java

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
=======
import com.canteen.Fot.OrderItem;
>>>>>>> b32616a28322c8a336207b7dd2ba248a3afe2a15:src/main/java/com/canteen/Fot/repository/OderItemRepositary.java
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OderItemRepositary extends CrudRepository<OrderItem, Integer> {

    @Query(value = "SELECT * FROM order_item WHERE cust_id=:username",nativeQuery = true)
    List<OrderItem> getItemId(@Param("username") String username);
}
