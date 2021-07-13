package com.example.demo;

import org.springframework.web.bind.annotation.*;

class Test {
    int no;
    String name;
}

@RestController
@RequestMapping("/")
public class SampleController {

    @GetMapping("/")
    public String test() {
        return  "test the application";
    }

    @GetMapping("/new")
    public String sampleNew() {
        return  "test new the application";
    }

    @GetMapping("/test")
    public String test(@RequestParam(value = "name") String name) {
        return "test Path" + name + " the application";
    }

    @GetMapping("/test/{id}")
    public String testPath(@PathVariable String id) {
        return  "test Path" + id + " the application";
    }

    @ResponseBody
    @PostMapping("/test")
    public String testPost(@RequestBody final Test test) {
        return "test Get with" + test.no + " the application";
    }

    @PutMapping("/test")
    public String testPut() {
        return  "test Put the application";
    }

    @DeleteMapping("/test")
    public String testDelete() {
        return  "test Delete the application";
    }
}
