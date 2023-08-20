package br.com.product.stockapi.shared;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record StockDto(
    String id,

    @NotNull(message = "Espaço total não pode estar vazio!")
    @Positive(message = "Espaço total deve ser um valor acima de 0")
    int totalSpace,

    @NotNull(message = "Espaço usado não pode estar vazio!")
    @PositiveOrZero
    int usedSpace
) { }
