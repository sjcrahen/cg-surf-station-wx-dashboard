package application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import application.core.email.EmailService;

@Controller
public class ContactController {

    @Autowired
    EmailService emailService;

    // @GetMapping("/contact")
    // public String showContact(Model model) {
    // Contact contact = new Contact();
    // model.addAttribute("contact", contact);
    // return "contact";
    // }
    //
    // @PostMapping("/contact")
    // public String handleFormSubmission(Contact contact) throws Exception {
    // emailService.sendEmail(contact);
    // return "redirect:/contact/success";
    // }
    //
    // @GetMapping("/contact/success")
    // public String getSuccess() {
    // return "success";
    // }

}
