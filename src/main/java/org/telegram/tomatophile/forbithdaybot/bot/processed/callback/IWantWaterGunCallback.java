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
public class IWantWaterGunCallback implements Callback {
    @Getter
    private final String data = "/wantWaterGun";

    private final ReplyService replyService;

    private final AdminDto admin;

    @Override
    public List<PartialBotApiMethod<Message>> process(String chatId) {
        return List.of(
                replyService.getTextMessage(chatId, "Отлично, тогда просто подожди некторое время!"),
                replyService.getTextMessage(admin.getChatId(), "Она хочет водяной пистолет!")
        );
    }
}
