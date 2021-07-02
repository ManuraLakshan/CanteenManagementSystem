package com.canteen.Fot.service;

import com.canteen.Fot.Category;
import com.canteen.Fot.repository.CategoryRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepositary CatRepo;
    public Iterable<Category> getAllCategories(){return CatRepo.findAll();}
}
