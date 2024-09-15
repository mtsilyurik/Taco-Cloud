package tacos.entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Table;


@Data
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table("ingredients")
public class Ingredient {
	@PrimaryKey
	public String id;

	public String name;
    // TODO Auto-generated method stub
    @Getter
    public Type type;

	public Ingredient(String id, String name, Type type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
}
