package hello.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Product {

    @Id
    private UUID uuid;

    @Column(name="display_name")
    private String displayName;

    public String getDisplayName() {
        return displayName;
    }
}
