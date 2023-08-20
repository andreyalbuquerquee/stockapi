package br.com.product.stockapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.product.stockapi.models.Stock;
import br.com.product.stockapi.repository.StocksRepository;
import br.com.product.stockapi.shared.StockDto;

@Service
public class StocksServiceImpl implements StocksService {
    @Autowired
    StocksRepository repository;

    @Override
    public List<StockDto> getAll() {
        return repository.findAll().stream().map(stock -> createStockDtoByStockClass(stock)).toList();
    }

    @Override
    public Optional<StockDto> getById(String id) {
        Optional<Stock> stock = repository.findById(id);

        if (!stock.isPresent()) {
            return Optional.empty();
        }
        
        return Optional.of(createStockDtoByOptional(stock));
    }

    @Override
    public StockDto create(StockDto newStockDto) {
        Stock stock = new Stock(newStockDto);
        repository.save(stock);

        return createStockDtoByStockClass(stock);
    }

    @Override
    public StockDto updateById(String id, StockDto updateStockDto) {
        Stock updatedStock = new Stock(updateStockDto);
        updatedStock.setId(id);
        repository.save(updatedStock);
        
        return createStockDtoByStockClass(updatedStock);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    private StockDto createStockDtoByStockClass(Stock stock) {
        return new StockDto(
        stock.getId(), 
        stock.getTotalSpace(), 
        stock.getUsedSpace()
        );
    }
    
    private StockDto createStockDtoByOptional(Optional<Stock> stockOptional) {
        return new StockDto(
        stockOptional.get().getId(), 
        stockOptional.get().getTotalSpace(), 
        stockOptional.get().getUsedSpace()
        );
    }

}
