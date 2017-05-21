package example.spring.web.config;

import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * User : Dongle (Dongkyun)
 * Date : 5/14/17
 */
@Configuration
public class HandlebarsConfig {
    private static final String HANDLEBARS_VIEW_BASE_PATH = "/WEB-INF/views";
    private static final String HANDLEBARDS_VIEW_SUFFIX = ".hbs";

    @Bean
    public HandlebarsViewResolver handlebarsViewResolver()  {
        HandlebarsViewResolver handlebarsViewResolver = new HandlebarsViewResolver();
        handlebarsViewResolver.setPrefix(HANDLEBARS_VIEW_BASE_PATH);
        handlebarsViewResolver.setSuffix(HANDLEBARDS_VIEW_SUFFIX);
        return handlebarsViewResolver;
    }
}
