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
    // mysql 연동
    private int foodIngreId;

    // 재료이름
    @Column(nullable = false)
    public String ingrediName;

    //---- getter setter ----
    public int getFoodId() {
        return foodIngreId;
    }

    public void setFoodId(int foodId) {
        this.foodIngreId = foodId;
    }

    public String getIngrediName() {
        return ingrediName;
    }

    public void setIngrediName(String ingrediName) {
        this.ingrediName = ingrediName;
    }
}
