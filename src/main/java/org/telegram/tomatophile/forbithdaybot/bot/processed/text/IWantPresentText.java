package org.telegram.tomatophile.forbithdaybot.bot.processed.text;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.tomatophile.bottemplate.keyboard.InlineKeyboardMarkupBuilder;
import org.telegram.tomatophile.bottemplate.processed.text.Text;

import java.util.List;

@Component
public class IWantPresentText implements Text {
    @Getter
    private final String text = "Хочу подарок!";

    @Override
    public List<PartialBotApiMethod<Message>> process(String chatId) {
        var keyboard = InlineKeyboardMarkupBuilder.create(chatId);

        keyboard
                .setText("Если хочешь водяной пистлет - нажми \"Хочу\"\nЕсли нет - нажми \"Твоя идея говно\" и напиши Артёму, чего хочешь")
                .addButton("Хочу", "/wantWaterGun")
                .nextRow().addButton("Твоя идея говно", "/itIsBadIdea");

        return List.of(keyboard.build());
    }
}
