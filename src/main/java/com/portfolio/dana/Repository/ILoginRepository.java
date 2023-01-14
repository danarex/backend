
package com.portfolio.dana.Repository;

import com.portfolio.dana.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginRepository extends JpaRepository <Login,Long>{
    
}

