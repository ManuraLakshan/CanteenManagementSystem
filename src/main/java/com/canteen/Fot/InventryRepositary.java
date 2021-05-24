package com.canteen.Fot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventryRepositary extends CrudRepository<Inventry, Integer> {
}
