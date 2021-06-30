package com.canteen.Fot.service;


import com.canteen.Fot.InventryRepositary;
import com.canteen.Fot.OderItemRepositary;
import com.canteen.Fot.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Order_ItemService {
    @Autowired
    private OderItemRepositary orderRepo;

    public void saveItem(OrderItem orderItem){
        orderRepo.save(orderItem);
    }

}
