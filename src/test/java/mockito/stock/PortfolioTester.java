package mockito.stock;

import com.cetin.mockito.portfolio.Portfolio;
import com.cetin.mockito.portfolio.Stock;
import com.cetin.mockito.portfolio.StockService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-22
 */
public class PortfolioTester {
    Portfolio portfolio;
    StockService stockService;

    @Test
    void testPorfolioManagement() {
        Assertions.assertTrue(testMarketValue(), " Test Failed");
    }

    @BeforeEach
    private void setUp() {
        //Create a portfolio object which is to be tested.
        portfolio = new Portfolio();

        //Create the mock object stock service
        stockService = mock(StockService.class);

        //set the stockService to the portfolio
        portfolio.setStockService(stockService);
    }

    private boolean testMarketValue() {
        //Create a list of stocks to be added to the portfolio
        List<Stock> stockList = new ArrayList<>();
        Stock stock1 = new Stock("1","google",10.0);
        Stock stock2 = new Stock("2","amazon",20.0);

        stockList.add(stock1);
        stockList.add(stock2);

        portfolio.setStocks(stockList);

        //mock the behavior of stock service to return the value of various stocks
        when(stockService.getPrice(stock1)).thenReturn(50.00);
        when(stockService.getPrice(stock2)).thenReturn(100.00);

        double marketValue = portfolio.getMarketValue();

        return marketValue == 2500.0;
    }
}
