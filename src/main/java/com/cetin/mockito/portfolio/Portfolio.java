package com.cetin.mockito.portfolio;

import java.util.List;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-22
 */
public class Portfolio {
    private StockService stockService;
    private List<Stock> stocks;

    public Double getMarketValue(){
       return stocks.stream().mapToDouble(stock -> stockService.getPrice(stock) * stock.getQuantity()).sum();
    }

    public StockService getStockService() {
        return stockService;
    }

    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
