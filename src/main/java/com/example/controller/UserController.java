package com.example.controller;

import com.example.models.*;
import com.example.service.RoleService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLOutput;
import java.util.List;

@Controller()
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping("/list")
    public String getAllUser(Model model){
        Iterable<User> users=userService.listAll();
        model.addAttribute("users",users);
        return "user_role";
    }

    @RequestMapping("/create")
    public String createUser(Model model){

        User user=new User();
        Iterable<Role> roles=roleService.findAll();

        model.addAttribute("user",user);
        model.addAttribute("roles",roles);

        return "create_user";
    }

    @RequestMapping(value = "/create_confirm",method = RequestMethod.POST)
    public String createUserConfirm(@ModelAttribute("user") User user){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setEnabled(true);
        userService.save(user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editUser(@PathVariable(name="id") int id){
        User user=userService.get(id);
        Iterable<Role> roles=roleService.findAll();

        ModelAndView mav=new ModelAndView("edit_user");
        mav.addObject("user",user);
        mav.addObject("roles",roles);

        return mav;
    }

    @RequestMapping("/edit_confirm")
    public String editUserConfirm(@ModelAttribute(value = "user") User user){
        userService.save(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name="id") int id){
        userService.delete(id);
        return "redirect:/user/list";
    }
    @RequestMapping("/search")
    public String search(Model model ,@Param("keyword")  String keyword){
        Iterable<User> users=userService.listAll(keyword);
        model.addAttribute("users",users);
        return "user_role";
    }

}
