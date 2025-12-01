package sys.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sys.com.model.Task;
import sys.com.service.TaskService;

import java.util.Map;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAll());
        return "tasks";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("task", new Task());
        return "task_form";
    }

    @PostMapping("")
    public String saveTaskFromForm(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/tasks";
    }

    @PostMapping("/save")
    public String saveTaskFromModal(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> editTask(@PathVariable Long id) {
        Task task = taskService.getById(id);

        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(Map.of(
                "id", task.getId(),
                "title", task.getTitle(),
                "description", task.getDescription(),
                "priority", task.getPriority(),
                "status", task.getStatus(),
                "dueDate", task.getDueDate() != null ? task.getDueDate().toString() : ""
        ));
    }

    @GetMapping("/toggle/{id}")
    public String toggleStatus(@PathVariable Long id) {
        Task t = taskService.getById(id);
        if (t != null) {
            if ("Completada".equals(t.getStatus())) {
                t.setStatus("Pendiente");
            } else {
                t.setStatus("Completada");
            }
            taskService.save(t);
        }
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        taskService.delete(id);
        return "redirect:/home";
    }
}


