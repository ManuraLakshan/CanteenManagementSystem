package com.canteen.Fot.repository;

import com.canteen.Fot.entity.Ordercart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderCartRepo extends CrudRepository<Ordercart,Integer> {

    @Query(value = "SELECT * FROM Ordercart WHERE cust_id=:username",nativeQuery = true)
    List<Ordercart> findAll(String username);
}
