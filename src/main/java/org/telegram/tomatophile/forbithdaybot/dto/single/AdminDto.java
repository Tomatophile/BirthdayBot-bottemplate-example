package org.telegram.tomatophile.forbithdaybot.dto.single;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Component
@Data
@Accessors(chain = true)
public class AdminDto {
    private String chatId;
}
