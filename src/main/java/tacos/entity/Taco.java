package tacos.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@Getter
@Setter
@Entity
public class Taco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Date createdAt = new Date();
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;
	
	@NotNull
	@Size(min=1, message="Choose at least 1 ingredient")
	@ManyToMany
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();

	@Override
	public String toString() {
		return "Taco [name=" + name + ", ingredients=" + ingredients + "]";
	}
	  
	 
	  
}
