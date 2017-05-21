package example.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * User : Dongle (Dongkyun)
 * Date : 5/11/17
 */
@RestController
@Api(value = "helloWorld", description="Hello world controller")
@RequestMapping("/hello")
public class HelloWorldController {
    @ApiOperation(
            value = "This is the hello world api.",
            notes = "It returns 'hello <your name>'",
            response = String.class
    )
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@PathVariable String name)    {
        String result = "Hello " + name;
        return result;
    }
}
