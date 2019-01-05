package my.examples.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @GetMapping("/plus")
    fun plus(@RequestParam("value1") values1: Int,
             @RequestParam("value2") values2: Int): String {
        return "result ${(values1 + values2)}"
    }
}
