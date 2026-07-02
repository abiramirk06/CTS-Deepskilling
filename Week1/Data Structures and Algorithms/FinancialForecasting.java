class FinancialForecasting {

    // Recursive method to calculate future value
    public static double futureValue(double currentValue,
                                     double growthRate,
                                     int years) {

        if (years == 0) {
            return currentValue;
        }

        return futureValue(currentValue * (1 + growthRate),
                           growthRate,
                           years - 1);
    }

    public static void main(String[] args) {

        double currentValue = 10000; // Initial amount
        double growthRate = 0.10;    // 10% growth
        int years = 5;

        double result = futureValue(currentValue, growthRate, years);

        System.out.printf("Future Value after %d years = %.2f",
                           years, result);
    }
}