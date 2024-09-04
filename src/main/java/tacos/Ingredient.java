package tacos;

import lombok.Data;

@Data
public class Ingredient {
	public String id;
	public String name;
	public Type type;
	
	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}

	public Ingredient(String id, String name, Type type) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public Type getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
