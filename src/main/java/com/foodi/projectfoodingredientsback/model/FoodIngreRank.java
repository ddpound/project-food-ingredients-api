package com.foodi.projectfoodingredientsback.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FoodIngreRank.class) // 엔티티 아래에다 두기
@Entity
public class FoodIngreRank implements Serializable {

    // 복합키, 객체 그자체가 키가 되려면 Serializable(직렬화)시키고
    // @IdClass를 어노테이션 시켜야한다
    @Id
    @JoinColumn(name = "foodIngreId")
    @OneToOne//  참조하려는 테이블의 컬럼
    private  FoodIngre foodIngreId;

    @Column
    private int counter;



    // ---  getter setter ---
    public FoodIngre getFoodIngre() {
        return foodIngreId;
    }

    public void setFoodIngre(FoodIngre foodIngre) {
        this.foodIngreId = foodIngre;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }


}
