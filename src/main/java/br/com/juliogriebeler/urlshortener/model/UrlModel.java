package br.com.juliogriebeler.urlshortener.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Calendar;

@Document(collection = "url")
public class UrlModel implements Serializable {

    public UrlModel(String token, String url, Calendar expiration) {
        this.token = token;
        this.url = url;
        this.expiration = expiration;
    }

    @Id
    private String token;
    private String url;
    private Calendar expiration;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Calendar getExpiration() {
        return expiration;
    }

    public void setExpiration(Calendar expiration) {
        this.expiration = expiration;
    }
}
