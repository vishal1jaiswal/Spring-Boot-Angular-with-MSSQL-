package com.id4.iprod.ITS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 

 
@Repository
public interface EmployeeRepository 
        extends JpaRepository<EmployeeEntity, Integer> {
 
}
