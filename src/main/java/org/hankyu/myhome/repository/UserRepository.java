package org.hankyu.myhome.repository;

import org.hankyu.myhome.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    //EntityGraph를 사용하면 fetch 타입 무시됨.
    @EntityGraph(attributePaths = {"boards"})
    List<User> findAll();

    User findByUsername(String username);

}
