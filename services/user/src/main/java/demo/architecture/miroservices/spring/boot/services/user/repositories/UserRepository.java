package demo.architecture.miroservices.spring.boot.services.user.repositories;

import demo.architecture.miroservices.spring.boot.services.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long id);
}
