package com.canteen.Fot.service;


<<<<<<< HEAD
import com.canteen.Fot.OderItemRepositary;
=======
import com.canteen.Fot.repository.OderItemRepositary;
>>>>>>> b32616a28322c8a336207b7dd2ba248a3afe2a15
import com.canteen.Fot.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Order_ItemService {
    @Autowired
    private OderItemRepositary orderRepo;



    public void saveItem(OrderItem orderItem){
        orderRepo.save(orderItem);
    }

    public List<OrderItem> listAll() {
        return (List<OrderItem>) orderRepo.findAll();
    }


    //get item id and price for process
    public List<OrderItem> getItemIds(String username) {
        return orderRepo.getItemId(username);
    }
//    public List<OrderedItemProcedure> getCustomer_Id(String para){
//       return orderRepo.display_orderItems(para);
//    }


}

