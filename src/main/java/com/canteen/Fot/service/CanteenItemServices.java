package com.canteen.Fot.service;


import com.canteen.Fot.entity.CanteenItem;
import com.canteen.Fot.repository.CanteenItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CanteenItemServices {

    @Autowired
    private CanteenItemRepository canItemRepo;

    public List<CanteenItem> getAllItems(){
        return (List<CanteenItem>) canItemRepo.findAll();
    }

    public void addItem(CanteenItem cn){
        canItemRepo.save(cn);
    }

    public void deleteItem(int id){
        canItemRepo.deleteById(id);
    }

    public CanteenItem get(int id){
        return canItemRepo.findById(id).get();
    }
}
