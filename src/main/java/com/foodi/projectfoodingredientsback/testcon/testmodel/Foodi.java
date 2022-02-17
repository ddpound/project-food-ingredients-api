package com.foodi.projectfoodingredientsback.testcon.testmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

// 무시해놔야함
@JsonIgnoreProperties(ignoreUnknown = true)
public class Foodi {

    private COOKRCP01 cOOKRCP01;


    public Foodi() {
    }

    public Foodi(COOKRCP01 cOOKRCP01) {
        super();
        this.cOOKRCP01 = cOOKRCP01;
    }

    public COOKRCP01 getCOOKRCP01() {
        return cOOKRCP01;
    }

    public void setCOOKRCP01(COOKRCP01 cOOKRCP01) {
        this.cOOKRCP01 = cOOKRCP01;
    }




















}