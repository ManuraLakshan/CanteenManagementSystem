package com.canteen.Fot.repository;


import com.canteen.Fot.OrderItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OderItemRepositary extends CrudRepository<OrderItem, Integer> {

    @Query(value = "SELECT * FROM order_item WHERE cust_id=:username",nativeQuery = true)
    List<OrderItem> getItemId(@Param("username") String username);
}
