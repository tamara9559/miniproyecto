package Service;

import com.example.proyectocorte2.Dto.UsersDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class UserService {

    private List<UsersDto> users;

    public UserService() {
        users = new ArrayList<>();
        users.add(new UsersDto(1L, "John", "john@cue.edu", "password1"));
        users.add(new UsersDto(2L, "juan", "juan@cue.edu", "password2"));
        users.add(new UsersDto(3L, "pepe", "pepe@cue.edu", "password3"));
    }

    public List<UsersDto> list() {
        return users;
    }
}