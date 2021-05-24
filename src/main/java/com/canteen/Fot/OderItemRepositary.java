package com.canteen.Fot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OderItemRepositary extends CrudRepository<OrderItem, Integer> {
}
