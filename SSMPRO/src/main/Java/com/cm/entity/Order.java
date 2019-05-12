package com.cm.entity;

public class Order {
    private long id;
    private String ownerName;
    private String productName;
    private long ownerId;
    private long productId;
    private int productCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }


    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Order(long ownerId, long productId, int productCount){
        this.ownerName = "Unknow";
        this.productName = "Unknow";
        this.ownerId = ownerId;
        this.productId = productId;
        this.productCount = productCount;
    }

    public Order(long ownerId, String ownerName, long productId, String productName, int productCount){
        this.ownerName = ownerName;
        this.productName = productName;
        this.ownerId = ownerId;
        this.productId = productId;
        this.productCount = productCount;
    }

}
