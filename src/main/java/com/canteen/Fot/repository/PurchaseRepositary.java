package com.canteen.Fot.repository;

import com.canteen.Fot.service.PurchesdLog;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepositary extends CrudRepository<PurchesdLog,Integer> {
}
