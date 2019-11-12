package br.com.juliogriebeler.urlshortener.repository;

import br.com.juliogriebeler.urlshortener.model.UrlModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<UrlModel, String> {
}
