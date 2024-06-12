package com.example.proyectocorte2.Dto;



import Model.Category;

import java.time.LocalDate;

public record ProductDto(Long id, String name, Category category, int price, String sku, LocalDate fechaRegistro) {
}