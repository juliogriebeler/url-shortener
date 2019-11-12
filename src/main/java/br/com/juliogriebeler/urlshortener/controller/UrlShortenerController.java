package br.com.juliogriebeler.urlshortener.controller;

import br.com.juliogriebeler.urlshortener.dto.UrlRequest;
import br.com.juliogriebeler.urlshortener.dto.UrlResponse;
import br.com.juliogriebeler.urlshortener.model.UrlModel;
import br.com.juliogriebeler.urlshortener.service.UrlService;
import br.com.juliogriebeler.urlshortener.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UrlShortenerController {

    @Autowired
    private UrlService urlService;
    @Autowired
    private Utils utils;

    @PostMapping(value = "/shortener")
    public ResponseEntity shortenUrl(HttpServletRequest request, @RequestBody UrlRequest urlRequest) {
        try {
            UrlModel urlModel = urlService.shortenUrl(urlRequest.getUrl());
            return new ResponseEntity(
                    new UrlResponse(
                            utils.getBasePath(request.getRequestURL(), urlModel.getToken()),
                            urlModel.getExpiration().getTimeInMillis()),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
