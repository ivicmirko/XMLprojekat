package rs.ac.uns.ftn.admin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class TestController
{

    @GetMapping("/hello")
    public ResponseEntity get()
    {
        return new ResponseEntity("Hello from service ADMIN!", HttpStatus.OK);
    }
}
