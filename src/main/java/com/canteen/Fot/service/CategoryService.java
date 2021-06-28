package com.canteen.Fot.service;

import com.canteen.Fot.Category;
import com.canteen.Fot.CategoryRepositary;
import com.canteen.Fot.InventryRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepositary CatRepo;
    public Iterable<Category> getAllCategories(){return CatRepo.findAll();}

}
