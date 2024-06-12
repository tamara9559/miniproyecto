package Service;

import com.example.proyectocorte2.Dto.CategoryDto;
import com.example.proyectocorte2.Dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> list();

    List<ProductDto> listar();

    Optional<ProductDto> porId(Long id);
    void guardar(ProductDto producto);
    void eliminar(Long id);
    List<CategoryDto> listarCategoria();
    Optional<CategoryDto> porIdCategoria(Long id);
}