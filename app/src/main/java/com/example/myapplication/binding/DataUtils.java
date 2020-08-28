package com.example.myapplication.binding;

import java.math.BigDecimal;

public class DataUtils {
     public static final String Tag="Product";
    public String productname;
    public String descrip;
    public BigDecimal normalPrice;
    public BigDecimal discount;
    public  int numberRating;
    public int imageProduct;

    public DataUtils(String productname, String descrip, BigDecimal normalPrice, BigDecimal discount, int numberRating, int imageProduct) {
        this.productname = productname;
        this.descrip = descrip;
        this.normalPrice = normalPrice;
        this.discount = discount;
        this.numberRating = numberRating;
        this.imageProduct = imageProduct;
    }

    public static String getTag() {
        return Tag;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public BigDecimal getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(BigDecimal normalPrice) {
        this.normalPrice = normalPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public int getNumberRating() {
        return numberRating;
    }

    public void setNumberRating(int numberRating) {
        this.numberRating = numberRating;
    }

    public int getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(int imageProduct) {
        this.imageProduct = imageProduct;
    }
}
