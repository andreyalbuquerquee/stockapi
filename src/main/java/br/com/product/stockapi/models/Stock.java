package br.com.product.stockapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.product.stockapi.shared.StockDto;

@Document("stocks")
public class Stock {
    
    
    @Id
    private String id;
    private int totalSpace;
    private int usedSpace;
    
    public Stock() {}

    public Stock(StockDto dto) {
        this.id = dto.id();
        this.totalSpace = dto.totalSpace();
        this.usedSpace = dto.usedSpace();
    }
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getTotalSpace() {
        return totalSpace;
    }
    public void setTotalSpace(int totalSpace) {
        this.totalSpace = totalSpace;
    }
    public int getUsedSpace() {
        return usedSpace;
    }
    public void setUsedSpace(int freeSpace) {
        this.usedSpace = freeSpace;
    }



}
