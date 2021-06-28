package org.telegram.tomatophile.forbithdaybot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class PostcardConfig {
    @Bean
    public List<InputFile> postcards(){
        var postcards = new ArrayList<InputFile>();

        var path = getClass().getClassLoader().getResource("postcard/").getPath();

        for(var file : new File(path).listFiles()){
            postcards.add(new InputFile(file));
        }

        return postcards;
    }
}
