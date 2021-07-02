package com.canteen.Fot.repository;

import com.canteen.Fot.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OderItemRepositary extends CrudRepository<OrderItem, Integer> {
}
