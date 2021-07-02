package com.canteen.Fot.repository;

import com.canteen.Fot.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepositary extends CrudRepository<Invoice, Integer> {
}
