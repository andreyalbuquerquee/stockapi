package br.com.product.stockapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.product.stockapi.services.StocksService;
import br.com.product.stockapi.shared.StockDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/estoques")
public class StocksController {
    @Autowired
    StocksService service;

    @GetMapping
    private ResponseEntity<List<StockDto>> getAllStocks() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Object> getStockById(@PathVariable String id) {
        Optional<StockDto> stock = service.getById(id);

        if (!stock.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estoque não encontrado.");
        } 
        
        return ResponseEntity.status(HttpStatus.OK).body(stock.get());     
    }

    @PostMapping
    private ResponseEntity<Object> createStock(@RequestBody @Valid StockDto newStockDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(newStockDto));
    }

    @PutMapping("/{id}")
    private ResponseEntity<Object> updateStock(@PathVariable String id, @RequestBody @Valid StockDto updateStockDto) {
        Optional<StockDto> stockDtoOptional = service.getById(id);

        if (!stockDtoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estoque não encontrado.");
        }
        
        StockDto updatedStock = service.updateById(id, updateStockDto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedStock); 
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deleteStockById(@PathVariable String id) {
        Optional<StockDto> stockDtoOptional = service.getById(id);

        if (!stockDtoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estoque não encontrado.");
        }
        service.deleteById(id);
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
