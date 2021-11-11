package co.usa.ciclo3.ciclo3.jar.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.ciclo3.ciclo3.jar.model.Admin;
import co.usa.ciclo3.ciclo3.jar.service.AdminService;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
public class AdminController {
    @Autowired

    private AdminService adminService;

    @GetMapping("all")
    public List<Admin>getAdmins(){
        return adminService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int id){
        return adminService.getAdmin(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin ad){
        return adminService.save(ad);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin ad) {
        return adminService.update(ad);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteAd(@PathVariable("id") int id) {
        return adminService.deleteAdmin(id);
    }





}
