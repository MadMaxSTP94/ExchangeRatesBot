package by.makson.exchange_rates_bot.client;

import by.makson.exchange_rates_bot.exception.ServiceException;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.util.Optional;

@Component
public class CBRClient {
    @Autowired
    private OkHttpClient client;

    @Value("${cbr.rates}")
    private String cbrCurrencyRatesXmlUrl;

    public Optional<String> getCurrencyRatesXML() throws ServiceException {
        var request = new Request.Builder()
                .url(cbrCurrencyRatesXmlUrl)
                .build();

        try  {
            var response = client.newCall(request).execute();
            var body = response.body();
            return body == null ? Optional.empty() : Optional.of(body.string());
        } catch (IOException e) {
            throw new ServiceException("Ошибка получения курсов валют от ЦБ РФ", e);
        }
    }
}
