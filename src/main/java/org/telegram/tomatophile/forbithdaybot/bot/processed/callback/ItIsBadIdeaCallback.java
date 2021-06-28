package org.telegram.tomatophile.forbithdaybot.bot.processed.callback;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.tomatophile.bottemplate.processed.callback.Callback;
import org.telegram.tomatophile.forbithdaybot.dto.single.AdminDto;
import org.telegram.tomatophile.forbithdaybot.service.ReplyService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ItIsBadIdeaCallback implements Callback {
    @Getter
    private final String data = "/itIsBadIdea";

    private final ReplyService replyService;

    private final AdminDto admin;

    @Override
    public List<PartialBotApiMethod<Message>> process(String chatId) {
        return List.of(
                replyService.getTextMessage(chatId, "Жаль(((\nТогда напиши Артёму, чего бы ты хотела"),
                replyService.getTextMessage(admin.getChatId(), "Твоя идея говно!")
        );
    }
}
