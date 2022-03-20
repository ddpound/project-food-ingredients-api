package com.foodi.projectfoodingredientsback.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 음식 레시피 데베
// 사실상 최종 데베

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodRecip {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipId;

    @Column
    private String foodName;










}
