package com.foodi.projectfoodingredientsback.model;

import lombok.*;

import javax.persistence.*;


// 음식 재료 데베

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodIngre {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int foodId;

    @Column
    public String foodName;


    // getter setter
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
