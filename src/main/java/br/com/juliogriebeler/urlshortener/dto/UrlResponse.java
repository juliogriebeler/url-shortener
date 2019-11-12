package br.com.juliogriebeler.urlshortener.dto;

public class UrlResponse {
    private String newUrl;
    private Long expiresAt;

    public UrlResponse(String newUrl, Long expiresAt) {
        this.newUrl = newUrl;
        this.expiresAt = expiresAt;
    }

    public String getNewUrl() {
        return newUrl;
    }

    public void setNewUrl(String newUrl) {
        this.newUrl = newUrl;
    }

    public Long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Long expiresAt) {
        this.expiresAt = expiresAt;
    }
}
