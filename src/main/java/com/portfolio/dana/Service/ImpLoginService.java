
package com.portfolio.dana.Service;

import com.portfolio.dana.Entity.Login;
import com.portfolio.dana.Interface.ILoginService;
import com.portfolio.dana.Repository.ILoginRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpLoginService implements ILoginService {
    @Autowired  ILoginRepository iloginRepository;

    @Override
    public List<Login> getLogin() {
        List <Login> login = iloginRepository.findAll();
        return login;
    }

    @Override
    public void saveLogin(Login login) {
        iloginRepository.save(login);
    }

    @Override
    public void deleteLogin(Long id) {
        iloginRepository.deleteById (id);
    }

    @Override
    public Login findLogin(Long id) {
        Login login = iloginRepository.findById(id).orElse(null);
        return login;
    }
    
}

