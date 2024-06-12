package com.example.proyectocorte2.Mapper;

import Model.Product;
import com.example.proyectocorte2.Dto.ProductDto;

public class ProductMapper {
    public static ProductDto mapFrom(Product producto){
        return new ProductDto(producto.getId(),producto.getName(),producto.getCategory(),producto.getPrice(), producto.getSku(), producto.getFechaRegistro());
    }
    public static Product mapFromDto(ProductDto productDto){
        return Product.builder()
                .id(productDto.id())
                .name(productDto.name())
                .category(productDto.category())
                .price(productDto.price())
                .sku(productDto.sku())
                .fechaRegistro(productDto.fechaRegistro())
                .build();
    }
}