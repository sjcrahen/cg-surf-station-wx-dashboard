package application.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import application.core.user.UserDto;
import application.core.user.UserService;

@Controller
public class SignupController {

    @Autowired
    UserService userService;

    @GetMapping("/signup")
    public String signUp(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute("user") @Valid UserDto userDto,
                    HttpServletRequest request, Errors errors) {
        userService.createUser(userDto);
        try {
            request.login(userDto.getUsername(), userDto.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
