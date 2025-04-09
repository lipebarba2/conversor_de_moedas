import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverterImpl();

        String[] currencies = {"USD", "EUR", "GBP", "JPY", "AUD", "CAD"};

        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("Escolha a moeda de origem:");
        for (int i = 0; i < currencies.length; i++) {
            System.out.println((i + 1) + ". " + currencies[i]);
        }
        int fromIndex = scanner.nextInt() - 1;

        System.out.println("Escolha a moeda de destino:");
        for (int i = 0; i < currencies.length; i++) {
            if (i != fromIndex) {
                System.out.println((i + 1) + ". " + currencies[i]);
            }
        }
        int toIndex = scanner.nextInt() - 1;

        System.out.println("Digite o valor a ser convertido:");
        double amount = scanner.nextDouble();

        String fromCurrency = currencies[fromIndex];
        String toCurrency = currencies[toIndex];

        double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);
        System.out.printf("%.2f %s equivalem a %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
    }
}