package Model;

import lombok.*;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Users {
    private Long id;
    private String username;
    private String password;
    private String email;
}
