package br.com.juliogriebeler.urlshortener.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenServiceTest {

    @Autowired
    private TokenService tokenService;

    @Test
    public void createToken() {
        System.out.print(tokenService.createToken());
    }

    @Test
    public void getRandomNumberInRange() {
        int res = tokenService.getRandomNumberInRange(10, 20);
        Assert.assertTrue(res >= 10 && res <= 20);
    }

    @Test
    public void getSingleCharacter() {
        Character res = tokenService.getSingleCharacter(1);
        Assert.assertFalse(res.toString().isBlank());

    }
}