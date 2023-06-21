package com.university.register.universityregister.example.controller;

import com.university.register.universityregister.example.UserRepository;
import com.university.register.universityregister.example.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserContoller {

  private final UserRepository userRepository;

  @PostMapping
  public Users save(@RequestBody Users user){
    return userRepository.save(user);
  }

  @GetMapping("/{id}")
  public Users getuserById(@PathVariable Integer id) {
    return  userRepository.findById(id).get();
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id){
    userRepository.deleteById(id);
  }

}
