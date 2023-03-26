package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MappingClassController {

    @GetMapping("/users")
    public String user() {
        return "get users";
    }

    @PostMapping("/users")
    public String addUser() {
        return "post user";
    }

    @GetMapping("/users/{userid}")
    public String findUser(@PathVariable String userid) {
        return "get userid = " + userid;
    }

    @PatchMapping("/users/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update userid = " + userId;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete userid = " + userId;
    }
}
