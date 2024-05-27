package it.nextdevs.mattina.service;

import it.nextdevs.mattina.DTO.UserLoginDto;
import it.nextdevs.mattina.entity.User;
import it.nextdevs.mattina.exceptions.UnauthorizedException;
import it.nextdevs.mattina.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTool jwtTool;

    public String authenticateUserAndCreateToken(UserLoginDto userLoginDto) {
        User user = userService.getUserByEmail(userLoginDto.getEmail());

        if (user.getPassword().equals(userLoginDto.getPassword())) {
            return jwtTool.createToken(user);
        } else {
            throw new UnauthorizedException("Error in authorization, re-login!");
        }
    }

}
