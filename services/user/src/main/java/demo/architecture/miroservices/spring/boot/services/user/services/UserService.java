package demo.architecture.miroservices.spring.boot.services.user.services;

import demo.architecture.miroservices.spring.boot.services.user.entities.User;
import demo.architecture.miroservices.spring.boot.services.user.repositories.UserRepository;
import demo.architecture.miroservices.spring.boot.services.user.vo.Department;
import demo.architecture.miroservices.spring.boot.services.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserService {

    private final UserRepository repository;
    private final RestTemplate restTemplate;

    @Autowired
    public UserService(final UserRepository repository, final RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public User save(final User user) {
        log.info("Saving user: {}", user);
        return this.repository.save(user);
    }

    public ResponseTemplateVO getById(final Long id) {
        log.info("Finding user with id: {}", id);
        User user = this.repository.findByUserId(id);
        log.info("Calling department service for fetching department with id: {}", user.getDepartmentId());
        Department department = this.restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" +
                user.getDepartmentId(), Department.class);
        return ResponseTemplateVO.builder().user(user).department(department).build();
    }

}
