package br.com.juliogriebeler.urlshortener.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilsTest {

    @Autowired
    private Utils utils;

    @Test
    public void getExpiration() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 1);
        Assert.assertEquals(c.get(Calendar.DAY_OF_MONTH), utils.getExpiration().get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void getBasePath() {
        String s = utils.getBasePath(new StringBuffer("http://www.teste.com/tst"), "er76TyU23");
        Assert.assertEquals("http://www.teste.com/tst/er76TyU23", s);
    }

}