package org.hankyu.myhome.repository;

import com.querydsl.jpa.impl.JPAQuery;
import org.hankyu.myhome.model.QUser;
import org.hankyu.myhome.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomizedUserRepositoryImpl implements CustomizedUserRepository{

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findByUsernameCustom(String username) {
        QUser quser = QUser.user;
        JPAQuery<?> query = new JPAQuery<>(em);
        List<User> users = query.select(quser)
                .from(quser)
                .where(quser.username.contains(username))
                .fetch();
        return users;
    }

    @Override
    public List<User> findByUsernameJDBC(String username) {
        List<User> users =jdbcTemplate.query(
                "SELECT * FROM USER WHERE username like ?",
                new Object[]{"%" +username + "%"},
                new BeanPropertyRowMapper(User.class));
        return users;
    }
}
