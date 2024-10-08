package tacos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import tacos.entity.Ingredient;

import java.util.Optional;

public interface IngredientRepository
         extends CrudRepository<Ingredient, String> {
}
