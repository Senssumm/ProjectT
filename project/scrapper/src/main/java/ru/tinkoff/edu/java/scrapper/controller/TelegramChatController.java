package ru.tinkoff.edu.java.scrapper.controller;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class TelegramChatController {

    @PostMapping(path = "/tg-chat/{id}")
    public String registerChat(@PathVariable(name = "id") long id) {
        return "Чат зарегистрирован"; 
    }

    @DeleteMapping(path = "/tg-chat/{id}")
    public String deleteChat(@PathVariable(name = "id") long id) {


        return "Чат (%s) успешно удалён".formatted(id);  

    }

}
