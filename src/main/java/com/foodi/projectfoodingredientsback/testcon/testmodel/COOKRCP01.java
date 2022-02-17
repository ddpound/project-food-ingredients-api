package com.foodi.projectfoodingredientsback.testcon.testmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

// 무시해놔야함
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonIgnoreProperties({"row", "result"})
public class COOKRCP01 {

    private String total_count;
    private List<Row> row = null;
    private Result result;


    public COOKRCP01() {
    }

    public COOKRCP01(String total_count){
        this.total_count = total_count;
    }


    public COOKRCP01(String total_count, List<Row> row, Result rESULT) {
        super();
        this.total_count = total_count;
        this.row = row;
        this.result = result;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public List<Row> getRow() {
        return row;
    }

    public void setRow(List<Row> row) {
        this.row = row;
    }

    public Result getRESULT() {
        return result;
    }

    public void setRESULT(Result result) {
        this.result = result;
    }

}
