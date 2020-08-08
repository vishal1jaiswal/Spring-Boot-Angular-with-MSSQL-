package com.id4.iprod.ITS;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

 
@Service
public class EmployeeService {
     
    @Autowired
    EmployeeRepository repository;
     
    public List<EmployeeEntity> getAllEmployees()
    {
        List<EmployeeEntity> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<EmployeeEntity>();
        }
    }
     
    public EmployeeEntity getEmployeeById(Integer id) throws Exception 
    {
        Optional<EmployeeEntity> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new Exception("No employee record exist for given id");
        }
    }
     
    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws Exception 
    {
        Optional<EmployeeEntity> employee = repository.findById( entity.getPartId());
         
        if(employee.isPresent()) 
        {
        	System.out.println("if present::");
            EmployeeEntity newEntity = employee.get();
            newEntity.setPartName(entity.getPartName());
            newEntity.setPartDesc(entity.getPartDesc());
            newEntity.setPartCdatetime(entity.getPartCdatetime());
            newEntity.setPartMdatetime(entity.getPartMdatetime());
            newEntity.setPartIsDeleted(entity.getPartIsDeleted());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
        	System.out.println("else");
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteEmployeeById(Integer id) throws Exception 
    {
    	System.out.println("idddd::"+id);

        Optional<EmployeeEntity> employee = repository.findById(id);
        System.out.println("employee::"+employee); 
         
        if(employee.isPresent()) 
        {
        	//repository.deleteById(id);
            repository.deleteById(id);
        } else {
            throw new Exception("No employee record exist for given id");
        }
    } 
}