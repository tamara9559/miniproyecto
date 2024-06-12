package Service;

import com.example.proyectocorte2.Dto.VehiclesDto;

import java.sql.SQLException;
import java.util.List;

public interface VehiclesService<T>{
    List<VehiclesDto> listar() throws SQLException;
}
