package com.example.demo1.dao;
import com.example.demo1.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据姓名查询
     * @param name
     * @return
     */
    @Query("select u from User u where name=:name")
    List<User> findByname(@Param("name") String name);
}