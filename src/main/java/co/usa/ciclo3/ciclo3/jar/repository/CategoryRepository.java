package co.usa.ciclo3.ciclo3.jar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.ciclo3.ciclo3.jar.model.Category;
import co.usa.ciclo3.ciclo3.jar.repository.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {
    @Autowired
    CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category cat){
        return categoryCrudRepository.save(cat);
    }

    // Metodo delete

    public void delete(Category cat){
        categoryCrudRepository.delete(cat);
    }
}
