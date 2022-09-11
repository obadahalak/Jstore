package Modules;

public class Product {
     private String TITLE = null;
     private String PRICE = null;
     private String DESCRIPE = null;
     private String IMG = null;
     private boolean IN_WISHLISIT = false;
     private boolean IN_CART = false;


    public Product(String TITLE, String PRICE, String DESCRIPE, String IMG, boolean IN_WISHLISIT, boolean IN_CART) {
        this.TITLE = TITLE;
        this.PRICE = PRICE;
        this.DESCRIPE = DESCRIPE;
        this.IMG = IMG;
        this.IN_WISHLISIT = IN_WISHLISIT;
        this.IN_CART = IN_CART;
    }

    public String getTITLE() {
        return TITLE;
    }

    public String getPRICE() {
        return PRICE;
    }

    public String getDESCRIPE() {
        return DESCRIPE;
    }

    public String getIMG() {
        return IMG;
    }

    public boolean isIN_WISHLISIT() {
        return IN_WISHLISIT;
    }

    public boolean isIN_CART() {
        return IN_CART;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public void setDESCRIPE(String DESCRIPE) {
        this.DESCRIPE = DESCRIPE;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }

    public void setIN_WISHLISIT(boolean IN_WISHLISIT) {
        this.IN_WISHLISIT = IN_WISHLISIT;
    }

    public void setIN_CART(boolean IN_CART) {
        this.IN_CART = IN_CART;
    }
}
