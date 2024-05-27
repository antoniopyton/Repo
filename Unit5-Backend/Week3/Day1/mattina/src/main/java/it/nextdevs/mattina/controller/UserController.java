package it.nextdevs.mattina.controller;

import it.nextdevs.mattina.DTO.UserDto;
import it.nextdevs.mattina.entity.User;
import it.nextdevs.mattina.exceptions.BadRequestException;
import it.nextdevs.mattina.exceptions.UserNotFoundException;
import it.nextdevs.mattina.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("/api/users")
//    public String saveUser(@RequestBody @Validated UserDto userDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new BadRequestException(bindingResult.getAllErrors().stream()
//                    .map(error -> error.getDefaultMessage()).reduce("", (s, s2) -> s + s2 ));
//        }
//        return userService.saveUser(userDto);
//    }

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/api/users/{id}")
    public User getUserById(int id) {
        Optional<User> userOptional = userService.getUserById(id);

        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new UserNotFoundException("User " + id + " does not exist");
        }
    }

    @PutMapping("/api/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody @Validated UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage()).reduce("", (s, s2) -> s + s2 ));
        }

        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/api/users/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }


}
