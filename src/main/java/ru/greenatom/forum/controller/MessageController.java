package ru.greenatom.forum.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/message")
@AllArgsConstructor
public class MessageController {


    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam UUID uuid) {

    }
}
