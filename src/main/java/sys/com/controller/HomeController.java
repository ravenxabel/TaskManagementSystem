package sys.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sys.com.service.TaskService;

@Controller
public class HomeController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("tasks", taskService.getAll());
        return "home";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}


