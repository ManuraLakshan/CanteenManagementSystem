package com.canteen.Fot.service;

import com.canteen.Fot.Inventry;
import com.canteen.Fot.InventryRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InventoryService {
    @Autowired
    private InventryRepositary InRepo;
    public  Iterable<Inventry> getAllStudents()
    {
        return InRepo.findAll();
    }
}
