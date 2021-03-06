package co.usa.ciclo3.ciclo3.jar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.jar.model.Admin;
import co.usa.ciclo3.ciclo3.jar.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin ad){
        if(ad.getId()== null){
            return adminRepository.save(ad);
        }else{
            Optional<Admin> consulta = adminRepository.getAdmin(ad.getId());
            if(consulta.isEmpty()){
                return adminRepository.save(ad);
            }else{
                return ad;
            }
        }
    }


    public Admin update(Admin ad) {

        if (ad.getId() != null) {
            Optional<Admin> consulta = adminRepository.getAdmin(ad.getId());
            if (!consulta.isEmpty()) {
                if (ad.getName() != null) {
                    consulta.get().setName(ad.getName());
                }
                if (ad.getEmail() != null){
                    consulta.get().setEmail(ad.getEmail());
                }
                if (ad.getPassword()!= null) {
                    consulta.get().setPassword(ad.getPassword());
                }

                return adminRepository.save(consulta.get());
            }
            
        }

        return ad;
    }

    public boolean deleteAdmin(int id){
        Optional<Admin> consulta = adminRepository.getAdmin(id);
        if (!consulta.isEmpty()) {
            adminRepository.delete(consulta.get());
            return true;
        }
        return false;
    }

}
