import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExchangeRateService {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/6b0aad00b26be873fec52331/latest/";

    public double getExchangeRate(String fromCurrency, String toCurrency) throws IOException {
        String urlStr = API_URL + fromCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonObject json = jp.parse(new InputStreamReader((InputStream) request.getContent())).getAsJsonObject();
        JsonObject rates = json.getAsJsonObject("conversion_rates");
        return rates.get(toCurrency).getAsDouble();
    }
}
