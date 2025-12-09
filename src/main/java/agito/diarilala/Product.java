package agito.diarilala;

import lombok.*;

import java.time.Instant;
@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Product {
    int id;
    String name;
    Instant creationDatetime;
    Category category;

    public String getCategoryName() {
        return null;
    }
}
