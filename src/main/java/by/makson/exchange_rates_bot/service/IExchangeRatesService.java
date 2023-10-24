package by.makson.exchange_rates_bot.service;

import by.makson.exchange_rates_bot.exception.ServiceException;

public interface IExchangeRatesService {
    String getUSDExchangeRate() throws ServiceException;

    String getEURExchangeRate() throws ServiceException;

    void clearUSDCache();

    void clearEURCache();

}
