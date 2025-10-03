package fhv.devops.international1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/test")
@RestController
public class TestRestController {
    @GetMapping("")
    public String getTest() {
        return "success";
    }
}
