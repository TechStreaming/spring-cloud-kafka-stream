package com.techstreams.springcloudkafkastream.action;

import com.techstreams.springcloudkafkastream.model.BaseResponse;
import com.techstreams.springcloudkafkastream.model.Greetings;
import com.techstreams.springcloudkafkastream.service.GreetingsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sun.java2d.xr.GrowableRectArray;

@RestController
@RequestMapping("/send")
public class GreetingsController {

    private final GreetingsService greetingsService;


    public GreetingsController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @GetMapping("/greetings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BaseResponse greetings(@RequestParam("message") String message) {
        Greetings greetings = Greetings.builder()
                .message(message)
                .timeStamp(System.currentTimeMillis())
                .build();
        return greetingsService.sendGreeting(greetings);
    }

    @PostMapping("/to-mobile")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BaseResponse greetingToPhone(@RequestBody Greetings response) {
        Greetings greetings = Greetings.builder()
                .message(response.getMessage())
                .timeStamp(System.currentTimeMillis())
                .phomneNumbers(response.getPhomneNumbers())
                .build();
        return greetingsService.sendGreeting(greetings);

    }
}
