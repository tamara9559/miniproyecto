package Service;

import Repository.Repository;
import com.example.proyectocorte2.Dto.CategoryDto;
import com.example.proyectocorte2.Dto.ProductDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductServiceJdbcImpl implements ProductService {
    private Repository<ProductDto> repositoryJdbc;
    private Repository<CategoryDto> repositoryJdbcCategpria;

    public ProductServiceJdbcImpl(Connection connection) {
        this.repositoryJdbc = new ProductRepositoryJdbcImpl(connection) {
            @Override
            public List<ProductDto> listar() throws SQLException {
                return null;
            }
        };
        this.repositoryJdbcCategpria = new CategoryRepositoryJdbcImpl(connection);
    }

    @Override
    public List<ProductDto> list() {
        try {
            return repositoryJdbc.listar();
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public List<ProductDto> listar() {
        return null;
    }

    @Override
    public Optional<ProductDto> porId(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.porId(id));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());

        }
    }

    @Override
    public void guardar(ProductDto producto) {
        try {
            repositoryJdbc.guardar(producto);
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());

        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repositoryJdbc.eliminar(id);
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());

        }
    }

    @Override
    public List<CategoryDto> listarCategoria() {
        try {
            return repositoryJdbcCategpria.listar();
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());

        }
    }

    @Override
    public Optional<CategoryDto> porIdCategoria(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbcCategpria.porId(id));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());

        }
    }
}
