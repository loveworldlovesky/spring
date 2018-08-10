package com.example.demo.seckill.product.domain;

public class ProductSeckill {
    private Integer id;

    private String productName;

    private String productNum;

    private Integer seckillNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public Integer getSeckillNum() {
        return seckillNum;
    }

    public void setSeckillNum(Integer seckillNum) {
        this.seckillNum = seckillNum;
    }
}