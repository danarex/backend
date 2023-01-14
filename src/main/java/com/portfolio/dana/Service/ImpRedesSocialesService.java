
package com.portfolio.dana.Service;

import com.portfolio.dana.Entity.RedesSociales;
import com.portfolio.dana.Interface.IRedesSocialesService;
import com.portfolio.dana.Repository.IRedesSocialesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpRedesSocialesService implements IRedesSocialesService {
    @Autowired  IRedesSocialesRepository iredessocialesRepository;

    @Override
    public List<RedesSociales> getRedesSociales() {
        List <RedesSociales> redessociales = iredessocialesRepository.findAll();
        return redessociales;
    }

    @Override
    public void saveRedesSociales(RedesSociales redessociales) {
        iredessocialesRepository.save(redessociales);
    }

    @Override
    public void deleteRedesSociales(Long id) {
        iredessocialesRepository.deleteById (id);
    }

    @Override
    public RedesSociales findRedesSociales(Long id) {
        RedesSociales redessociales = iredessocialesRepository.findById(id).orElse(null);
        return redessociales;
    }
    
}
