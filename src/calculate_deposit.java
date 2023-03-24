import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return getPercent(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return getPercent(amount + amount * yearRate * depositPeriod, 2);
    }

    double getPercent(double value, int exponent) {
        double scale = Math.pow(10, exponent);
        return Math.round(value * scale) / scale;
    }

    void calculateWithInput()
    {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int initialAmount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double resultAmount = 0;
        if (action == 1) {
            resultAmount = calculateSimplePercent(initialAmount, 0.06, period);
        } else if (action == 2) {
            resultAmount = calculateComplexPercent(initialAmount, 0.06, period);
        }

        System.out.println("Результат вклада: " + initialAmount + " за " + period + " лет превратятся в "
                + resultAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateWithInput();
    }
}