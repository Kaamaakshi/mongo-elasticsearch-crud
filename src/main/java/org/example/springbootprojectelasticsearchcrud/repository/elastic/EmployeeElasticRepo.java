package org.example.springbootprojectelasticsearchcrud.repository.elastic;

import org.example.springbootprojectelasticsearchcrud.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeElasticRepo extends ElasticsearchRepository<Employee, Long> {
}
