package com.example.demo1.dao;
import com.example.demo1.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.validation.constraints.Max;
import java.util.List;

public interface UserPageAndSortRepository extends PagingAndSortingRepository<User, Long> {
    /**
     * 根据姓名查询
     * @param name
     * @return
     */
    List<User> findByname(String name);
}