package com.canteen.Fot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositary extends CrudRepository<Customer, String> {
}
