package com.foodi.projectfoodingredientsback.repository;

import com.foodi.projectfoodingredientsback.model.FoodIngre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodIngreRepository extends JpaRepository<FoodIngre, Integer> {

    // select * from FoodIngre where name like "%name%"
    List<FoodIngre> findByIngrediNameLike(String name);




}
