package com.example.pharmacist.repositories;

import com.example.pharmacist.models.PharmacistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacistRepository extends JpaRepository<PharmacistModel,Integer> {

    @Query(value = "select count(*) from pharmacist_details where user_name=:user_name and password=:password", nativeQuery = true)
    public int loginPharmacist(@Param("user_name") String user_name, @Param("password") String password);

}
