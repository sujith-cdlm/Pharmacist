package com.example.pharmacist.controllers;

import com.example.pharmacist.models.PharmacistModel;
import com.example.pharmacist.repositories.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@RestController
public class PharmacistController {

    @Autowired
    PharmacistRepository pharmacistRepository;


    @PostMapping(path = "/registration", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public HashMap registerPharmacist(@RequestBody PharmacistModel pharmacistModel){
        HashMap<String,Object> hashMap = new HashMap<String,Object>();
        System.out.println("UserName : "+pharmacistModel.getUserName());
        System.out.println("Password : "+pharmacistModel.getPassword());
        System.out.println("Name : "+pharmacistModel.getFullName());
        System.out.println("Address : "+pharmacistModel.getAddress());
        System.out.println("Designation : "+pharmacistModel.getDesignation());
        System.out.println("Email : "+pharmacistModel.getEmail());
        System.out.println("Phone : "+pharmacistModel.getPhoneNumber());
        if(pharmacistModel!=null){
            pharmacistRepository.save(pharmacistModel);
            hashMap.put("status","Success");
            hashMap.put("data",pharmacistModel);
        }else {
            hashMap.put("status","Failed");
        }
        return hashMap;
    }

}
