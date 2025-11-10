public interface IProducts {
    int TotalSales(int[][] productSales);
    double Average(int[][] ProductSales);
    int Maxsale(int[][] ProductSales);
    int MinSale (int[][] ProductSales);

    double calculateTotal(double[][] sales);

    double calculateAverage(double[][] sales);

    double findMaximum(double[][] sales);

    double findMinimum(double[][] sales);
}