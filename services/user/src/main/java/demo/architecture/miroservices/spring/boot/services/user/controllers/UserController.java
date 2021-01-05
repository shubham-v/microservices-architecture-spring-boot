package demo.architecture.miroservices.spring.boot.services.user.controllers;

import demo.architecture.miroservices.spring.boot.services.user.entities.User;
import demo.architecture.miroservices.spring.boot.services.user.services.UserService;
import demo.architecture.miroservices.spring.boot.services.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(final UserService service) {
        this.service = service;
    }

    @PutMapping
    public User put(@RequestBody final User user) {
        log.info("Creating/Replacing user: {}", user);
        return this.service.save(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO fetchById(@PathVariable final Long id) {
        log.info("Getting user with id: {}", id);
        return this.service.getById(id);
    }

}
