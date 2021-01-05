package demo.architecture.miroservices.spring.boot.services.department.services;

import demo.architecture.miroservices.spring.boot.services.department.entities.Department;
import demo.architecture.miroservices.spring.boot.services.department.repositories.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    @Autowired
    public DepartmentService(final DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department save(final Department department) {
        log.info("Saving department: {}", department);
        return this.repository.save(department);
    }

    public Department getById(final Long id) {
        log.info("Getting department By Id: {}", id);
        return this.repository.findByDepartmentId(id);
    }
}
