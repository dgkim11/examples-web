package example.spring.mvc.i18n.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class HelloController {
    @Resource
    private MessageSource messageSource;

    @Resource
    CookieLocaleResolver localeResolver;

    @Value("${welcome.message}")
    private String helloMessage;

    /**
    * Request mapping for user
    */
    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public ModelAndView helloPage(@PathVariable String name) {
        ModelAndView mv= new ModelAndView("hello");
        mv.addObject("name", name);
        return mv;
    }

    @RequestMapping(value = "/api/en/hello/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String helloEn(@PathVariable String name){
        return messageSource.getMessage("welcome.message", new Object[] { name }, Locale.ENGLISH);
    }

    @RequestMapping(value = "/api/ko/hello/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String helloKo(@PathVariable String name){
        return messageSource.getMessage("welcome.message", new Object[] { name }, Locale.KOREA);
    }

    @RequestMapping(value = "/api/hello/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String helloDefault(HttpServletRequest httpServletRequest, @PathVariable String name){
        return messageSource.getMessage("welcome.message", new Object[] { name }, localeResolver.resolveLocale(httpServletRequest));
    }

    @RequestMapping(value = "/api/change/locale/{locale}")
    @ResponseBody
    public String changeLocale(@PathVariable String locale) {
        localeResolver.setDefaultLocale(Locale.forLanguageTag(locale));
        return "changed locale to " + locale;
    }

    @RequestMapping(value = "/api/locale")
    @ResponseBody
    public String getLocale(HttpServletRequest httpServletRequest) {
        return "Current locale is " + localeResolver.resolveLocale(httpServletRequest);
    }

    @RequestMapping(value = "/hello/{name}")
    @ResponseBody
    public ModelAndView getLocale(@PathVariable String name) {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("name", name);

        return mv;
    }

}