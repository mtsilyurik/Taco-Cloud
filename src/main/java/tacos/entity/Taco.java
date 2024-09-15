package tacos.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Getter
@Setter
@Table("tacos")
public class Taco {
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED) // Определение ключа раздела Cassandra
	private UUID id = Uuids.timeBased();


	@PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,
						ordering = Ordering.DESCENDING) // Определение ключа класстеризации
	private Date createdAt = new Date();
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;

	@Size(min=1, message = "You must choose at least one ingredient")
	@Column("ingredients")
	private List<IngredientUDT> ingredients = new ArrayList<IngredientUDT>();

	public void addIngredient(Ingredient ingredient){
		this.ingredients.add(TacoUDRUtils.toIngredientUDT(ingredient));
	}

	@Override
	public String toString() {
		return "Taco [name=" + name + ", ingredients=" + ingredients + "]";
	}

	public String getName() {
		return this.name;
	}

	public List<IngredientUDT> getIngredients() {
		return ingredients;
	}
}
