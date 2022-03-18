package com.foodi.projectfoodingredientsback.testinvironment.testmodel.recipeingre;

import java.util.ArrayList;

public class Grid201508270000000002271 {
    public int totalCnt;
    public int startRow;
    public int endRow;
    public Result result;
    public ArrayList<Row> row;

    public Grid201508270000000002271() {
    }

    public Grid201508270000000002271(int totalCnt, int startRow, int endRow, Result result, ArrayList<Row> row) {
        this.totalCnt = totalCnt;
        this.startRow = startRow;
        this.endRow = endRow;
        this.result = result;
        this.row = row;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ArrayList<Row> getRow() {
        return row;
    }

    public void setRow(ArrayList<Row> row) {
        this.row = row;
    }
}
