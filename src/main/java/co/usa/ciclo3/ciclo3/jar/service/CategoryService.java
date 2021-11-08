package co.usa.ciclo3.ciclo3.jar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.jar.model.Category;
import co.usa.ciclo3.ciclo3.jar.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category cat){
        if(cat.getId()==null){
            return categoryRepository.save(cat);
        }else{
            Optional<Category> consulta = categoryRepository.getCategory(cat.getId());
            if(consulta.isEmpty()){
                return categoryRepository.save(cat);
            }else{
                return cat;
            }
        }
    }
}
