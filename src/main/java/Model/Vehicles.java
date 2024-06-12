package Model;

import lombok.*;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Vehicles {
    private Long id;
    private String name;
    private String price;
    private String availability;
}
