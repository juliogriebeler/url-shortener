package br.com.juliogriebeler.urlshortener.service;

import br.com.juliogriebeler.urlshortener.util.Constants;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class TokenService {

    public String createToken() {
        StringBuilder token = new StringBuilder();
        for (int i = 0; i <= getRandomNumberInRange(5, 25); i++) {
            token.append(getSingleCharacter(getRandomNumberInRange(0, 2)));
        }
        return token.toString();
    }

    protected int getRandomNumberInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    protected char getSingleCharacter(int type) {
        if (type == 0)
            return (char) getRandomNumberInRange(Constants.CHAR_MAP_LOWERCASE_START, Constants.CHAR_MAP_LOWERCASE_END);
        else if (type == 1)
            return (char) getRandomNumberInRange(Constants.CHAR_MAP_UPPERCASE_START, Constants.CHAR_MAP_UPPERCASE_END);
        else
            return (char) getRandomNumberInRange(Constants.CHAR_MAP_NUMBERS_START, Constants.CHAR_MAP_NUMBERS_END);
    }
}
