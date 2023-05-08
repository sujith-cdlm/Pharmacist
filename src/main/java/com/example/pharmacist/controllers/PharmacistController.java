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

    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public HashMap loginPharmacist(@RequestBody PharmacistModel pharmacistModel){
        HashMap<String,Object> hashMap = new HashMap<String,Object>();
        System.out.println("UserName : "+pharmacistModel.getUserName());
        System.out.println("Password : "+pharmacistModel.getPassword());
        if(pharmacistModel.getUserName()==null || pharmacistModel.getUserName().isEmpty()){
            hashMap.put("message","UserName cannot be blank");
            hashMap.put("status","Failed");
            return hashMap;
        }
        if(pharmacistModel.getPassword()==null || pharmacistModel.getPassword().isEmpty()){
            hashMap.put("message","Password cannot be blank");
            hashMap.put("status","Failed");
            return hashMap;
        }
        if(!pharmacistModel.getUserName().isEmpty() && !pharmacistModel.getPassword().isEmpty()){
            int count = pharmacistRepository.loginPharmacist(pharmacistModel.getUserName(),pharmacistModel.getPassword());
            if(count>0){
                hashMap.put("status","Login Success");
                return hashMap;
            }else{
                hashMap.put("status","Login Failed");
                return hashMap;
            }
        }
        return hashMap;
    }

}
