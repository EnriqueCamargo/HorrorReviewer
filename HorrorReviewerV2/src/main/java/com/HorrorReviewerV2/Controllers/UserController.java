package com.HorrorReviewerV2.Controllers;


import com.HorrorReviewerV2.Entities.User;
import com.HorrorReviewerV2.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users/")
    public ResponseEntity<?> getAllUsers(){
        try{
            List<User> userList=userService.getAllusers();
            return ResponseEntity.ok(userList);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        try{
            User user = userService.getUserById(id);
            if(user!=null){
                return ResponseEntity.status(201).body(user);
            }else{
                return ResponseEntity.status(404).body("usuario con id "+id+" no existe");
            }
        }catch (Exception e ){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/api/users/")
    public ResponseEntity<?>postNewUser(@RequestBody User user){
        try {
            User newUser=userService.postUser(user);
            return ResponseEntity.ok(newUser);
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    @PutMapping("/api/users/update/{id}")
    public ResponseEntity<?> putUser(@PathVariable Integer id,@RequestBody User user){
        try {
            User updatedUser=userService.UpdateUser(user,id);
            if(updatedUser!=null){
                return ResponseEntity.ok(updatedUser);

            }else {
                return ResponseEntity.status(404).body("No hay un usuario con id "+id);
            }
            } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Integer id){
        try{
            if(userService.deleteUser(id)){
                return ResponseEntity.ok("Usuario Eliminado Exitosamente");
            }else{
                return ResponseEntity.status(404).body("Usuario no encontrado o no existe");
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }


    }
}
