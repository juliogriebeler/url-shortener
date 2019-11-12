package br.com.juliogriebeler.urlshortener.controller;

import br.com.juliogriebeler.urlshortener.exception.UrlExpiredException;
import br.com.juliogriebeler.urlshortener.exception.UrlNotFoundException;
import br.com.juliogriebeler.urlshortener.model.UrlModel;
import br.com.juliogriebeler.urlshortener.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

@Controller
public class UrlRedirectController {

    @Autowired
    private UrlService urlService;

    private static Logger LOGGER = LoggerFactory.getLogger(UrlRedirectController.class);

    @GetMapping(value = "/shortener/{token}")
    public ResponseEntity retrieveUrl(HttpServletResponse response, @PathVariable(value = "token") String token) {
        try {
            UrlModel urlModel = urlService.retrieveUrl(token).orElseThrow(() -> new UrlNotFoundException());
            if (urlModel.getExpiration().before(Calendar.getInstance()))
                throw new UrlExpiredException();
            response.sendRedirect(urlModel.getUrl());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (UrlNotFoundException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } catch (UrlExpiredException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(HttpStatus.GONE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
