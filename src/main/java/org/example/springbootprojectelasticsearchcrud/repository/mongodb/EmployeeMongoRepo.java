package org.example.springbootprojectelasticsearchcrud.repository.mongodb;

import org.example.springbootprojectelasticsearchcrud.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeMongoRepo extends MongoRepository<Employee,Long> {
}
