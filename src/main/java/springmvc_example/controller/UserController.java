package springmvc_example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc_example.model.User;
import springmvc_example.service.UserService;


@Controller
@RequestMapping(value="/user")
public class UserController {
 
 @Autowired
 UserService userService;
 
 @RequestMapping(value="/list", method=RequestMethod.GET)
 public ModelAndView list(){
  ModelAndView model = new ModelAndView("user/user_page");
  
  List list = userService.listAllUsers();
  model.addObject("listUser", list);
  
  return model;
 }
 
 @RequestMapping(value="/add", method=RequestMethod.GET)
 public ModelAndView add(){
  ModelAndView model = new ModelAndView("user/user_form");
  
  User user = new User();
  model.addObject("userForm", user);
  
  return model;
 }
 
 @RequestMapping(value="/update/{user_name}", method=RequestMethod.GET)
 public ModelAndView update(@PathVariable("user_name") String user_name){
  ModelAndView model = new ModelAndView("user/user_form");
  
  User user = userService.findUserByname(user_name);
  model.addObject("userForm", user);
  
  return model;
 }
 
 @RequestMapping(value="/save", method=RequestMethod.POST)
 public ModelAndView save(@ModelAttribute("userForm") User user){
  if(user != null && user.getUser_name() != null){
   userService.updateUser(user);
  } else {
   userService.addUser(user);
  }
  
  return new ModelAndView("redirect:/user/list");
 }

}