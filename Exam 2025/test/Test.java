package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.ProductSales;  // adjust the package path if needed

public class ProductSalesTest {

    @Test
    public <ProductSales> void testCalculateTotalSales() {
        ProductSales ps = new ProductSales();


        double[][] sales = {
                {300, 150, 700},
                {250, 200, 600}
        };

        double expectedTotal = 22000.0;  // sum of all values
        double actualTotal = ps.calculateTotal(sales);

        assertEquals(expectedTotal, actualTotal, 0.001,
                "Total sales calculation failed!");
    }

    @Test
    public void testCalculateAverageSales() {
        ProductSales ps = new ProductSales();

        double[][] sales = {
                {300, 150, 700, 2500},
                {250, 200, 600, 4500}
        };

        double expectedAverage = 22000.0 / 8;  // total / number of entries
        double actualAverage = ps.calculateAverage(sales);

        assertEquals(expectedAverage, actualAverage, 0.001,
                "Average sales calculation failed!");
    }
}


