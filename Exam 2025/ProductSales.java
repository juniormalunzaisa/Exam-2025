public abstract class ProductSales implements IProducts {

    @Override
    public double calculateTotal(double[][] sales) {
        double total = 0;
        for (double[] year : sales) {
            for (double value : year) {
                total += value;
            }
        }
        return total;
    }

    @Override
    public double calculateAverage(double[][] sales) {
        int count = 0;
        double total = 0;
        for (double[] year : sales) {
            for (double value : year) {
                total += value;
                count++;
            }
        }
        return (count == 0) ? 0 : total / count;
    }

    @Override
    public double findMaximum(double[][] sales) {
        double max = sales[0][0];
        for (double[] year : sales) {
            for (double value : year) {
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }

    @Override
    public double findMinimum(double[][] sales) {
        double min = sales[0][0];
        for (double[] year : sales) {
            for (double value : year) {
                if (value < min) {
                    min = value;
                }
            }
        }
        return min;
    }
}
