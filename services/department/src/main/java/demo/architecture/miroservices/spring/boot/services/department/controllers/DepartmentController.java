package demo.architecture.miroservices.spring.boot.services.department.controllers;

import demo.architecture.miroservices.spring.boot.services.department.entities.Department;
import demo.architecture.miroservices.spring.boot.services.department.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(final DepartmentService service) {
        this.service = service;
    }

    @PutMapping
    public Department put(@RequestBody final Department department) {
        log.info("Received request for creating/replacing department: {}", department);
        return this.service.save(department);
    }

    @GetMapping("/{id}")
    public Department fetchById(@PathVariable("id") final Long id) {
        log.info("Received request for getting department with id: {}", id);
        return this.service.getById(id);
    }

}
