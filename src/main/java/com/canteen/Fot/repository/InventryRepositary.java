package com.canteen.Fot.repository;

import com.canteen.Fot.Inventry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventryRepositary extends CrudRepository<Inventry, Integer> {

    //Filter items
    @Query(value = "SELECT * from Inventry i WHERE i.cat_id=4 and i.name like %:keyword%",nativeQuery = true)
    List<Inventry> findByKeyword(@Param("keyword") String keyword);

    //Select main category
    @Query(value = "SELECT * from Inventry i WHERE i.cat_id = :id ",nativeQuery = true)
    List<Inventry> findMainCate(@Param("id") Integer id);


}
