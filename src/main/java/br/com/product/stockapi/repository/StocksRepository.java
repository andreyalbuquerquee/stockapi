package br.com.product.stockapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.product.stockapi.models.Stock;

public interface StocksRepository extends MongoRepository<Stock, String> {
    
}
