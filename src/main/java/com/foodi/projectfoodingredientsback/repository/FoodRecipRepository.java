package com.foodi.projectfoodingredientsback.repository;

import com.foodi.projectfoodingredientsback.model.FoodRecip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRecipRepository extends JpaRepository<FoodRecip, Integer> {


}
