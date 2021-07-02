package com.canteen.Fot.repository;

import com.canteen.Fot.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositary extends CrudRepository<Customer, String> {
}
