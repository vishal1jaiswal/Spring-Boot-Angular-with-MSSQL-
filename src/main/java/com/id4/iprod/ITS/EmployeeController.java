package com.id4.iprod.ITS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 

 @SpringBootApplication
@RestController
@RequestMapping("/employees")
public class EmployeeController  
{
    @Autowired
    EmployeeService service;
 
   // public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	/*
	 * @RequestMapping(value = "/view2", method = RequestMethod.GET)
	 * 
	 * @GetMapping public String getAllEmployeesview2() {
	 * System.out.println("hello index");
	 * 
	 * return "index"; }
	 */
    
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> list = service.getAllEmployees();
 
        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Integer id) 
                                                    throws Exception {
        EmployeeEntity entity = service.getEmployeeById(id);
 
        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity employee)
                                                    throws Exception {
    	employee.setPartCdatetime("cdate");
    	employee.setPartMdatetime("mdate");
    	employee.setPartIsDeleted((short) 0);
    	System.out.println("cont::name:: "+employee.getPartName());
        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/delete/{partId}", method = RequestMethod.DELETE)
    public HttpStatus deleteEmployeeById(@PathVariable("partId") Integer partId) 
                                                    throws Exception {
    	
    	System.out.println("delete cal----------");
    	System.out.println("id--::"+partId);
        service.deleteEmployeeById(partId);
        return HttpStatus.OK;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(EmployeeController.class, args);
        }
 
}