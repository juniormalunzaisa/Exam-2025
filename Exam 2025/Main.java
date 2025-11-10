import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int YEARS = 2;
        final int QUARTERS = 3;

        double[][] sales = new double[YEARS][QUARTERS];

        System.out.println("Enter product sales data for each quarter of 2 years:");
        for (int year = 0; year < YEARS; year++) {
            System.out.println("\nYear " + (year + 1) + ":");
            for (int quarter = 0; quarter < QUARTERS; quarter++) {
                System.out.print("  Quarter " + (quarter + 1) + " sales: ");
                sales[year][quarter] = input.nextDouble();
            }
        }

        double[] allSales = new double[YEARS * QUARTERS];
        int index = 0;
        for (int year = 0; year < YEARS; year++) {
            for (int quarter = 0; quarter < QUARTERS; quarter++) {
                allSales[index++] = sales[year][quarter];
            }
        }

        double total = 0;
        double max = allSales[0];
        double min = allSales[0];

        for (double s : allSales) {
            total += s;
            if (s > max) max = s;
            if (s < min) min = s;
        }

        double average = total / allSales.length;

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
