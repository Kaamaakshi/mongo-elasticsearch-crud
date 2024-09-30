package org.example.springbootprojectelasticsearchcrud.repository.elastic;

import org.example.springbootprojectelasticsearchcrud.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongodbRepository extends MongoRepository<Employee,Integer> {
}
