package tacos;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class IngredientByConverter {
	
	private Map<String, Ingredient> ingredientMap = new HashMap<String, Ingredient>();
	
	public IngredientByConverter() {
	    ingredientMap.put("FLTO", 
	            new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
	        ingredientMap.put("COTO", 
	            new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
	        ingredientMap.put("GRBF", 
	            new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
	        ingredientMap.put("CARN", 
	            new Ingredient("CARN", "Carnitas", Type.PROTEIN));
	        ingredientMap.put("TMTO", 
	            new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
	        ingredientMap.put("LETC", 
	            new Ingredient("LETC", "Lettuce", Type.VEGGIES));
	        ingredientMap.put("CHED", 
	            new Ingredient("CHED", "Cheddar", Type.CHEESE));
	        ingredientMap.put("JACK", 
	            new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
	        ingredientMap.put("SLSA", 
	            new Ingredient("SLSA", "Salsa", Type.SAUCE));
	        ingredientMap.put("SRCR", 
	            new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
	}
	
//	@Override
	public Ingredient convert(String id) {
		return ingredientMap.get(id);
	}
}
