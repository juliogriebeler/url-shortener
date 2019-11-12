package br.com.juliogriebeler.urlshortener.service;

import br.com.juliogriebeler.urlshortener.model.UrlModel;
import br.com.juliogriebeler.urlshortener.repository.UrlRepository;
import br.com.juliogriebeler.urlshortener.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UrlService {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UrlRepository urlRepository;
    @Autowired
    private Utils utils;

    public UrlModel shortenUrl(String url) {
        return urlRepository.save(new UrlModel(tokenService.createToken(), url, utils.getExpiration()));
    }

    public Optional<UrlModel> retrieveUrl(String token) {
        return urlRepository.findById(token);
    }
}
