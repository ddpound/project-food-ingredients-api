package com.foodi.projectfoodingredientsback.repository;

import com.foodi.projectfoodingredientsback.model.FoodIngre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodIngreRepository extends JpaRepository<FoodIngre, Integer> {
}
