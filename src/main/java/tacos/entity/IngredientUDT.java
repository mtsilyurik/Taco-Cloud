package tacos.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@UserDefinedType("ingredient")
public class IngredientUDT {
    private final String name;

    private final Ingredient.Type type;

    public IngredientUDT(String name, Ingredient.Type type) {
        this.name = name;
        this.type = type;
    }
}
