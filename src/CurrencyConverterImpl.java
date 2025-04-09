import java.io.IOException;

public class CurrencyConverterImpl implements CurrencyConverter {
    private ExchangeRateService exchangeRateService;

    public CurrencyConverterImpl() {
        this.exchangeRateService = new ExchangeRateService();
    }

    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        try {
            double rate = exchangeRateService.getExchangeRate(fromCurrency, toCurrency);
            return amount * rate;
        } catch (IOException e) {
            System.out.println("Erro ao obter a taxa de câmbio: " + e.getMessage());
            return 0;
        }
    }
}
