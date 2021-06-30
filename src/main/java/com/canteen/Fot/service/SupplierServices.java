package com.canteen.Fot.service;

import com.canteen.Fot.entity.Supplier;
import com.canteen.Fot.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SupplierServices {
    @Autowired
    private SupplierRepository supRepo;

    public List<Supplier> getAllSuppliers(){
        return (List<Supplier>) supRepo.findAll();
    }

    public void addSupplier(Supplier sup){
        supRepo.save(sup);
    }

    public void deleteSup(int id){
        supRepo.deleteById(id);
    }

    public Supplier get(int id){
        return supRepo.findById(id).get();
    }

}
