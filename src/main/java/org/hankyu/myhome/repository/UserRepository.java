package org.hankyu.myhome.repository;

import org.hankyu.myhome.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>,
        QuerydslPredicateExecutor<User> , CustomizedUserRepository {

    //EntityGraph를 사용하면 fetch 타입 무시됨.
    @EntityGraph(attributePaths = {"boards"})
    List<User> findAll();

    User findByUsername(String username);

    @Query("select u from User u where u.username like %?1%")
    List<User> findByUsernameQuery(String username);

    @Query(value = "select u from User u where u.username like %?1%", nativeQuery = true)
    List<User> findByUsernameNativeQuery(String username);



}
