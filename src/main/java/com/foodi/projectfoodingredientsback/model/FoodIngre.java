package com.foodi.projectfoodingredientsback.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodIngre {

    @Id
    private int ROW_NUM;

    @Column
    private int RECIPE_ID;

    @Column
    private int IRDNT_SN;

    @Column
    public String IRDNT_NM;

    @Column
    public String IRDNT_CPCTY;

    @Column
    public String IRDNT_TY_CODE;

    @Column
    public String IRDNT_TY_NM;

    public void setROW_NUM(int ROW_NUM) {
        this.ROW_NUM = ROW_NUM;
    }

    public void setRECIPE_ID(int RECIPE_ID) {
        this.RECIPE_ID = RECIPE_ID;
    }

    public void setIRDNT_SN(int IRDNT_SN) {
        this.IRDNT_SN = IRDNT_SN;
    }

    public void setIRDNT_NM(String IRDNT_NM) {
        this.IRDNT_NM = IRDNT_NM;
    }

    public void setIRDNT_CPCTY(String IRDNT_CPCTY) {
        this.IRDNT_CPCTY = IRDNT_CPCTY;
    }

    public void setIRDNT_TY_CODE(String IRDNT_TY_CODE) {
        this.IRDNT_TY_CODE = IRDNT_TY_CODE;
    }

    public void setIRDNT_TY_NM(String IRDNT_TY_NM) {
        this.IRDNT_TY_NM = IRDNT_TY_NM;
    }

    public int getROW_NUM() {
        return ROW_NUM;
    }

    public int getRECIPE_ID() {
        return RECIPE_ID;
    }

    public int getIRDNT_SN() {
        return IRDNT_SN;
    }

    public String getIRDNT_NM() {
        return IRDNT_NM;
    }

    public String getIRDNT_CPCTY() {
        return IRDNT_CPCTY;
    }

    public String getIRDNT_TY_CODE() {
        return IRDNT_TY_CODE;
    }

    public String getIRDNT_TY_NM() {
        return IRDNT_TY_NM;
    }
}
