package com.canteen.Fot.controller;

import com.canteen.Fot.entity.Supplier;
import com.canteen.Fot.service.SupplierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class SupplierController {

    @Autowired
    private SupplierServices supService;

    @RequestMapping(path = "viewall_supliers")
    public String getAllSuppliersList(Model model) {
        List<Supplier> supplierList = supService.getAllSuppliers();
        model.addAttribute("supplierList", supplierList);
        return "allsupliers";
    }

    @RequestMapping(path = "addnewsupplier")
    public String addSupplier(Model model) {
        Supplier sp = new Supplier();
        model.addAttribute("supplier", sp);
        return "add_supplier_form";
    }

    @RequestMapping(value = "/process_add_supplier", method = RequestMethod.POST)
    public String saveSupplier(@ModelAttribute("supplier") Supplier sp) {
        supService.addSupplier(sp);
        return "redirect:/viewall_supliers";
    }

    @RequestMapping(path = "/editSupplier/{id}")
    public ModelAndView showEditSupplierPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_supplier");
        Supplier supplier = supService.get(id);
        mav.addObject("supplier", supplier);
        return mav;
    }

    @RequestMapping(path = "/deleteSupplier/{id}")
    public String deleteSupplier(@PathVariable(name = "id") int id) {
        supService.deleteSup(id);
        return "redirect:/viewall_supliers";
    }

    //this calling method must to be changed
    @RequestMapping(path = "/viewsupplier")
    public String loadInventory() {
        return "redirect:/viewall_supliers";
    }
}
