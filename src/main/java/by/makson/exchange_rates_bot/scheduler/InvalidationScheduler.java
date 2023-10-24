package by.makson.exchange_rates_bot.scheduler;

import by.makson.exchange_rates_bot.service.ExchangeRatesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class InvalidationScheduler {
    @Autowired
    private ExchangeRatesServiceImpl service;

    @Scheduled(cron = "* 0 0 * * ?")
    public void invalidateCache() {
        service.clearUSDCache();
        service.clearEURCache();
    }
}
