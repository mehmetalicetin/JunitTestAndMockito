package com.cetin.mockito.portfolio;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-22
 */
public class Stock {
    private String stockId;
    private String name;
    private Double quantity;

    public Stock(String stockId, String name, Double quantity) {
        this.stockId = stockId;
        this.name = name;
        this.quantity = quantity;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
