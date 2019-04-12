package com.example.demo1.controller;

import com.example.demo1.dao.UserPageAndSortRepository;
import com.example.demo1.dao.UserRepository;
import com.example.demo1.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(value = "sping JPA data",tags = "sping JPA data测试接口模块")
@Controller
@RequestMapping(path = "/demo")
public class UserController {
   @Autowired
   private UserRepository userRepository;
   @ApiOperation(value = "接口说明",notes = "注册用户")
   @ApiImplicitParams({
           @ApiImplicitParam(name = "name",value = "请求的用户姓名",required = true,dataType = "String",paramType = "query"),
           @ApiImplicitParam(name = "email",value = "请求的用户邮箱",required = true,dataType = "String",paramType = "query")
   } )
   @GetMapping(path = "/add")
   @ResponseBody
   public User addNewUser(@RequestParam String name, @RequestParam String email) {
      User n = new User();
      n.setName(name);
      n.setEmail(email);
      userRepository.save(n);
      return n;
   }
   @ApiOperation(value = "接口说明",notes = "注册用户")
   @GetMapping(path = "/all")
   @ResponseBody
   public Iterable<User> getAllUsers() {
      return userRepository.findAll();
   }

   @ApiOperation(value = "接口说明",notes = "用户数量")
   @GetMapping(path = "/count")
   @ResponseBody
   public long getAllUsersCount() {
      return userRepository.count();
   }

   @ApiOperation(value = "接口说明",notes = "验证排序和分页查询方法")
   @GetMapping(path = "/page")
   @ResponseBody
   public Page<User> getAllUsersByPage() {
      return userRepository.findAll(new PageRequest(1,10,new Sort(new
              Sort.Order(Sort.Direction.ASC,"id")
              )));
   }
   @ApiOperation(value = "接口说明",notes = "验证排序查询方法")
   @GetMapping(path = "/sort")
   @ResponseBody
   public Iterable<User> getAllUsersWithSort() {
      return userRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC,"id")));
   }
   @ApiOperation(value = "接口说明",notes = "自定义查询方法")
   @ApiImplicitParam(name = "name",value = "请求的用户姓名",required = true,dataType = "String",paramType = "query")
   @GetMapping(path = "/define")
   @ResponseBody
   public List<User> getAllUsersByName(@RequestParam String name) {
      return userRepository.findByname(name);
   }
}