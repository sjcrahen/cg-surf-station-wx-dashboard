package application.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import application.core.user.UserAlreadyExistsException;
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

    @GetMapping("/signup-user-exists")
    public String signUpWithError(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        model.addAttribute("userExists", true);
        return "signup";
    }

    @PostMapping("/signup")
    public String createNewUser(@ModelAttribute("user") @Valid UserDto userDto,
                    BindingResult bindingResult, HttpServletRequest request) {
        try {
            userService.createNewUser(userDto);
        } catch (UserAlreadyExistsException e) {
            return "redirect:/signup-user-exists";
        }

        if (bindingResult.hasErrors()) {
            return "signup";
        }
        try {
            request.login(userDto.getEmail(), userDto.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
            return "redirect:/login";
        }
        return "redirect:/";
    }
}
