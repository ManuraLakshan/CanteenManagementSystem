package com.canteen.Fot.repository;

import com.canteen.Fot.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepositary extends CrudRepository<Category,Integer> {

}
