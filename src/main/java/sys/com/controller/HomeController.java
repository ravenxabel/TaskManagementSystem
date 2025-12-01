package sys.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import sys.com.service.TaskService;

@Controller
public class HomeController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/home")
    public String home(Model model) {
        var tasks = taskService.getAll();

        // Serializar las tareas a JSON para JavaScript
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String tasksJson = "[]";
        try {
            tasksJson = mapper.writeValueAsString(tasks);
        } catch (JsonProcessingException e) {
            System.err.println("Error al serializar tareas a JSON: " + e.getMessage());
        }

        model.addAttribute("tasks", tasks);           // Para Thymeleaf
        model.addAttribute("tasksJson", tasksJson);   // Para JavaScript
        return "home";
    }

//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }
}


