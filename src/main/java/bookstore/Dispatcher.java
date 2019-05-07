package bookstore;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dispatcher {
    public Dispatcher() {
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public String testEndpoint() {
        return "asd";
    }
}