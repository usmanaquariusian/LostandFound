package com.example.usmanahmed.lostandfound;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Usman Ahmed on 27/12/2017.
 */

public class FoundModel {
    @SerializedName("product_name")
    private String product_name;

    @SerializedName("product_category")
    private String product_category;

    @SerializedName("founder_name")
    private String founder_name;

    @SerializedName("founder_no")
    private String founder_no;

    public FoundModel(String product_name, String product_category, String founder_name, String founder_no) {
        this.product_name = product_name;
        this.product_category = product_category;
        this.founder_name = founder_name;
        this.founder_no = founder_no;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_category() {
        return product_category;
    }

    public String getFounder_name() {
        return founder_name;
    }

    public String getFounder_no() {
        return founder_no;
    }
}
