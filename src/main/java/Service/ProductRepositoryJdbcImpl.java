package Service;

import Model.Category;
import Model.Product;
import Repository.Repository;
import com.example.proyectocorte2.Dto.ProductDto;
import com.example.proyectocorte2.Mapper.ProductMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ProductRepositoryJdbcImpl implements Repository<ProductDto> {
    private Connection conn;

    public ProductRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }


    @Override
    public List<ProductDto> list() throws SQLException {
        List<ProductDto> products = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT p.*, c.nombre as categoria FROM productojdbc as p " +
                     " INNER JOIN categoria as c ON (p.id_categoria=c.id) ORDER BY p.id ASC")) {
            while (rs.next()) {
                Product p = getProducto(rs);
                ProductDto productDto = ProductMapper.mapFrom(p);
                products.add(productDto);
            }
        }
        return products;
    }

    @Override
    public ProductDto porId(Long id) throws SQLException {
        Product product = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT p.*, c.nombre as categoria FROM productojdbc as p " +
                " INNER JOIN categoria as c ON (p.id_categoria=c.id) WHERE p.id = ? ")) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    product = getProducto(rs);
                }

            }


        }
        return ProductMapper.mapFrom(product);
    }

    @Override
    public void guardar(ProductDto productDto) throws SQLException {
        String sql;
        if (productDto.id() != null && productDto.id() > 0) {
            sql = "UPDATE productojdbc set nombre=?, precio=?, sku=?, id_categoria=? where id=?";
        } else {
            sql = "INSERT INTO productojdbc (nombre, precio,sku,id_categoria, fecha_registro) VALUES(?,?,?,?,?)";
        }
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, productDto.name());
            stmt.setInt(2, productDto.price());
            stmt.setString(3, productDto.sku());
            stmt.setLong(4, productDto.category().getId());

            if (productDto.id() != null && productDto.id() > 0) {
                stmt.setLong(5, productDto.id());
            } else {
                stmt.setDate(5, Date.valueOf(productDto.fechaRegistro()));
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "DELETE FROM productojdbc WHERE id =?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }

    private static Product getProducto(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setId(rs.getLong("id"));
        p.setName(rs.getString("nombre"));
        p.setPrice(rs.getInt("precio"));
        p.setSku(rs.getString("sku"));
        p.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
        Category category = new Category();
        category.setId(rs.getLong("id_categoria"));
        category.setName(rs.getString("categoria"));
        p.setCategory(category);
        return p;
    }
}
