package org.telegram.tomatophile.forbithdaybot.bot.processed.text;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.tomatophile.bottemplate.processed.text.Text;
import org.telegram.tomatophile.forbithdaybot.service.ReplyService;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class IWantPostcardText implements Text {
    @Getter
    private String text = "Хочу открытку!";

    private final ReplyService replyService;

    private final Random random;

    private final List<InputFile> postcards;

    @Override
    public List<PartialBotApiMethod<Message>> process(String chatId) {
        var postcard = postcards.get(random.ints(0, postcards.size()).findFirst().getAsInt());

        return List.of(replyService.getPhotoMessage(chatId, postcard));
    }
}
