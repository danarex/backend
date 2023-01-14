
package com.portfolio.dana.Repository;

import com.portfolio.dana.Entity.RedesSociales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRedesSocialesRepository extends JpaRepository <RedesSociales,Long>{
    
}
