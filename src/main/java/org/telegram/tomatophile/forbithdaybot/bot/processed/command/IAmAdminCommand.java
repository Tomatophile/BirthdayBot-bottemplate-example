package org.telegram.tomatophile.forbithdaybot.bot.processed.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.tomatophile.bottemplate.processed.command.Command;
import org.telegram.tomatophile.forbithdaybot.dto.single.AdminDto;
import org.telegram.tomatophile.forbithdaybot.service.ReplyService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IAmAdminCommand implements Command {
    @Getter
    private final String command = "/iAmArtyom";

    private final ReplyService replyService;

    private final AdminDto admin;

    @Override
    public List<PartialBotApiMethod<Message>> process(String chatId) {
        admin.setChatId(chatId);

        return List.of(replyService.getTextMessage(chatId, "Админ установлен!"));
    }
}
