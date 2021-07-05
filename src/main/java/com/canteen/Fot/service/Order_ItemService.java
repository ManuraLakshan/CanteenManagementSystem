package com.canteen.Fot.service;



import com.canteen.Fot.OrderItem;
import com.canteen.Fot.repository.OderItemRepositary;
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

    public void updateQuantity(Integer quant, Integer orderId) {
        orderRepo.updateQuant(quant, orderId);
    }

    public void addToInvoice(Integer orderId) {
         orderRepo.invoiceupdate(orderId);
    }

    public void addAllToInvoice(String username) {
        orderRepo.allInvoiceupdate(username);
    }

    public void quantityChange(Integer quentity, Integer itemId, String username) {
        orderRepo.quantityChangingFunction(quentity,itemId,username);
    }
//    public List<OrderedItemProcedure> getCustomer_Id(String para){
//       return orderRepo.display_orderItems(para);
//    }


}

