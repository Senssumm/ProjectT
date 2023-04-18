package ru.tinkoff.edu.java.bot.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.java.bot.configuration.ApplicationConfig;
import ru.tinkoff.edu.java.bot.dto.LinkUpdate;
import ru.tinkoff.edu.java.bot.exception.LinkNotSupportedException;
import ru.tinkoff.edu.java.bot.service.UserResponseService;
import ru.tinkoff.edu.java.bot.utils.LinkParseResultPresenter;
import ru.tinkoff.edu.java.link_parser.LinkParserResult;
import ru.tinkoff.edu.java.link_parser.LinkParserService;

@RestController
@RequiredArgsConstructor
public class BotController {
    private final LinkParserService linkParserService;
    private final UserResponseService userResponseService;
    private final ApplicationConfig applicationConfig;

    @PostMapping("/updates")
    public void updates(@Valid @RequestBody LinkUpdate linkUpdate) {
        LinkParserResult result = linkParserService.parse(linkUpdate.url())
                .orElseThrow(LinkNotSupportedException::new);

        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append(applicationConfig.message().update());
        messageBuilder.append(" ");

        var linkPresenter = new LinkParseResultPresenter(messageBuilder, linkUpdate.url().toString());
        linkPresenter.present(result);

        var messageText = messageBuilder.toString();
        linkUpdate.tgChatIds().forEach(id -> userResponseService.sendMessage(id, messageText));
    }
}
