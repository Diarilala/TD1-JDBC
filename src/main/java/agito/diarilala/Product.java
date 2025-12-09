package agito.diarilala;

import lombok.*;

import java.time.Instant;
@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Product {
    private final int id;
    private final String name;
    private final Instant creationDatetime;
    private final Category category;

    public String getCategoryName() {
        return null;
    }
}
