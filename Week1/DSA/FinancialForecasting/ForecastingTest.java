class FinancialForecaster {
    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        if (periods == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static double calculateFutureValueOptimized(double currentValue, double growthRate, int periods) {
        return currentValue * power(1 + growthRate, periods);
    }

    private static double power(double base, int exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp % 2 == 0) {
            double half = power(base, exp / 2);
            return half * half;
        } else {
            return base * power(base, exp - 1);
        }
    }
}

public class ForecastingTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Financial Forecasting ===");
        double pv = 1000.0;
        double rate = 0.05;
        int periods = 10;

        double fv1 = FinancialForecaster.calculateFutureValue(pv, rate, periods);
        double fv2 = FinancialForecaster.calculateFutureValueOptimized(pv, rate, periods);

        System.out.printf("Present Value: $%.2f%n", pv);
        System.out.printf("Growth Rate: %.1f%%%n", rate * 100);
        System.out.printf("Periods: %d%n", periods);
        System.out.printf("Future Value (Standard Recursion): $%.2f%n", fv1);
        System.out.printf("Future Value (Optimized Recursion): $%.2f%n", fv2);
    }
}
