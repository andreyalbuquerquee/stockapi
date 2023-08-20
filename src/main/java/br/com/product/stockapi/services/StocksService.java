package br.com.product.stockapi.services;

import java.util.List;
import java.util.Optional;

import br.com.product.stockapi.shared.StockDto;

public interface StocksService {
    List<StockDto> getAll();
    Optional<StockDto> getById(String id);
    StockDto create(StockDto newStockDto);
    StockDto updateById(String id, StockDto updateStockDto);
    void deleteById(String id);
}
