package br.com.juliogriebeler.urlshortener.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class Utils {

    @Value("${urlshortener.service.expirationhours}")
    private int expirationHours;

    private static Logger LOGGER = LoggerFactory.getLogger(Utils.class);

    public Calendar getExpiration() {
        Calendar expiration = new GregorianCalendar();
        expiration.setTimeInMillis(expiration.getTimeInMillis() + ((expirationHours * 60) * 60) * 1000);
        return expiration;
    }

    public String getBasePath(StringBuffer requestUrl, String token) {
        return requestUrl.append(Constants.SLASH).append(token).toString();
    }
}
