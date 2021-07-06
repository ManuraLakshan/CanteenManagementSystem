package com.canteen.Fot.service;

import com.canteen.Fot.Inventry;
import com.canteen.Fot.entity.User;
import com.canteen.Fot.repository.InventryRepositary;
import com.canteen.Fot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InventoryService {
    @Autowired
    private InventryRepositary InRepo;
    @Autowired
    private UserRepository userRpo;
    //Display every normal items
    public  Iterable<Inventry> getAllitems()
    {
        return InRepo.findOtherFoods();
    }

    //Filter normal items
    public List<Inventry> findByKeyword(String keyword){
        return InRepo.findByKeyword(keyword);
    }
    //Select Category
    public List<Inventry> findByMainFoodId(Integer id){
        return InRepo.findMainCate(id);
    }


    public void getItemNameAndPrice() {
    }

    public List<User> findUserType(String username) {
        return userRpo.findUserType(username);
    }
}
