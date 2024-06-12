package Model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Product {
    private Long id;
    private String name;
    private Category category;
    private int price;
    private String sku;
    private LocalDate fechaRegistro;
    public Product(Long id, String name, String tipo, int price) {
        this.id = id;
        this.name = name;
        Category category = new Category();
        category.setName(tipo);
        this.category = category;
        this.price = price;
    }
}

