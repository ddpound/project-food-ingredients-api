package com.foodi.projectfoodingredientsback.testcon.testmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// 무시해놔야함
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result{

    private String mSG;
    private String cODE;

    /**
     * No args constructor for use in serialization
     *
     */
    public Result() {
    }

    /**
     *
     * @param mSG
     * @param cODE
     */
    public Result(String mSG, String cODE) {
        super();
        this.mSG = mSG;
        this.cODE = cODE;
    }

    public String getMSG() {
        return mSG;
    }

    public void setMSG(String mSG) {
        this.mSG = mSG;
    }

    public String getCODE() {
        return cODE;
    }

    public void setCODE(String cODE) {
        this.cODE = cODE;
    }

}
