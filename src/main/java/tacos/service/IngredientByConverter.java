package tacos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.entity.Ingredient;
import tacos.repository.IngredientRepository;

@Component
public class IngredientByConverter implements Converter<String, Ingredient> {

	private final IngredientRepository ingredientRepository;

	@Autowired
	public IngredientByConverter(IngredientRepository ingredientRepository) {
		System.out.println("IngredientByConverter");
		this.ingredientRepository = ingredientRepository;
	}

	@Override
	public Ingredient convert(String id) {
		return ingredientRepository.findById(id).orElse(null);
	}
}
