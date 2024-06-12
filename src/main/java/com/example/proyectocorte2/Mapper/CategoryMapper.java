package com.example.proyectocorte2.Mapper;

import Model.Category;
import Model.Product;
import com.example.proyectocorte2.Dto.CategoryDto;

public class CategoryMapper mapFrom(Category categoria){
public static CategoryDto mapFrom(Category categoria){
    return new CategoryDto(categoria.getId(),categoria.getNombre());
}
public static Product mapFromDto(CategoryDto categoryDto) {
    return Product.builder()
            .id(categoryDto.id())
            .nombre(categoryDto.nombre())
            .build();
}