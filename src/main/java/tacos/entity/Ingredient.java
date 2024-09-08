package tacos.entity;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import lombok.*;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Table;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ingredient {
	@Id
	public String id;

	public String name;
    // TODO Auto-generated method stub
    @Getter
    public Type type;

	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
}
