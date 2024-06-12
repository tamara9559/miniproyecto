package Repository;

import com.example.proyectocorte2.Dto.ProductDto;

import java.sql.SQLException;
import java.util.List;

    public interface Repository <T>{
        List<ProductDto> list() throws SQLException;

        List<T> listar()throws SQLException;
        T porId(Long id) throws SQLException;
        void guardar(T t) throws SQLException;
        void eliminar(Long id) throws SQLException;

    }
