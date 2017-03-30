package chas.twitter.clone.domain.repository;

import chas.twitter.clone.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>{
    //User findFirstByUserId(String userId);
}
