package CurrencyConverter;

import java.util.Scanner;
public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] currencyName = {"Eur", "USD", "TL"};
        double[] currencyRate = {1.08, 1.0, 0.031}; // Курсы: EURO, USD, TL

        while (true) {

            System.out.println("Приветствуем в CurrencyConverter!");
            int choice = printMenuGetInput("Выберите исходную валюту:");
            if (checkValue(choice)) continue; // if 0 exit; if wrong input start from beginning

            double amount = readCheckAmount();

            int targetCurrency = printMenuGetInput("Выберите валюту, в которую нужно перевести:");
            if (checkValue(targetCurrency)) continue;
            System.out.println();

            double result = Calc(amount, choice, targetCurrency);
            System.out.println(amount + currencyName[choice - 1] + " -> " + result + currencyName[targetCurrency - 1]);
            System.out.println();

        }

    }

    public static int printMenuGetInput(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        System.out.println("1. EURO");
        System.out.println("2. USD");
        System.out.println("3. TL");
        System.out.println("0. Выход");
        System.out.println();
        System.out.print("Ваш выбор (только цифру): ");
        return scanner.nextInt();
    }

    public static boolean checkValue(int choice) {
        boolean worngInput = false;
        if (choice == 0) {
            System.out.println("Вы выбрали выход");
            System.exit(0);
        }

        if (choice < 1 || choice > 3) {
            System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
            worngInput = true;
        }
        return worngInput;
    }

    public static double Calc(double amount, int sellCurrency, int targetCurrency) {
        String[] currencyName = {"Eur", "USD", "TL"};
        double[] currencyRate = {1.08, 1.0, 0.031}; // Курсы: EURO, USD, TL
        return   amount * currencyRate[sellCurrency - 1] / currencyRate[targetCurrency - 1];
    }

    public static double readCheckAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сумму в исходной валюте: ");
        double amount = scanner.nextDouble();

        return((amount > 0) ? amount : readCheckAmount());

    }
}
