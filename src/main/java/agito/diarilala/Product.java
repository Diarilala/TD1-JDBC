package agito.diarilala;

import lombok.*;

import java.time.Instant;
@Data
@AllArgsConstructor

public class Product {
    private int id;
    private String name;
    private Instant creationDatetime;
    private Category category;

    public String getCategoryName() {
        return null;
    }
}
