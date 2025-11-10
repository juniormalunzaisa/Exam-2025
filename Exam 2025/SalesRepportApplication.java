import java.util.Scanner;

public class SalesRepportApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int YEARS = 2;
        final int QUARTERS = 3;

        double[][] sales = new double[YEARS][QUARTERS];

        System.out.println("Enter sales for each quarter of 2 years:");
        for (int year = 0; year < YEARS; year++) {
            System.out.println("\nYear " + (year + 1) + ":");
            for (int quarter = 0; quarter < QUARTERS; quarter++) {
                System.out.print("  Quarter " + (quarter + 1) + " sales: ");
                sales[year][quarter] = input.nextDouble();
            }
        }

        ProductSales ps = new ProductSales() {
            /**
             * @param productSales
             * @return
             */
            @Override
            public int TotalSales(int[][] productSales) {
                return 0;
            }

            /**
             * @param ProductSales
             * @return
             */
            @Override
            public double Average(int[][] ProductSales) {
                return 0;
            }

            /**
             * @param ProductSales
             * @return
             */
            @Override
            public int Maxsale(int[][] ProductSales) {
                return 0;
            }

            /**
             * @param ProductSales
             * @return
             */
            @Override
            public int MinSale(int[][] ProductSales) {
                return 0;
            }
        };

        double total = ps.calculateTotal(sales);
        double average = ps.calculateAverage(sales);
        double max = ps.findMaximum(sales);
        double min = ps.findMinimum(sales);

        System.out.println("\n======================================");
        System.out.println("     PRODUCT SALES REPORT (2 Years)   ");
        System.out.println("======================================");
        for (int year = 0; year < YEARS; year++) {
            System.out.print("Year " + (year + 1) + ": ");
            for (int quarter = 0; quarter < QUARTERS; quarter++) {
                System.out.print(sales[year][quarter] + "  ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------");
        System.out.println("Total Sales: " + total);
        System.out.println("Average Sales: " + average);
        System.out.println("Maximum Sale: " + max);
        System.out.println("Minimum Sale: " + min);
        System.out.println("======================================");

        input.close();
    }
}

