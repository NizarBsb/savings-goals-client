package com.starlingbank.savingClient

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

@SpringBootTest(classes = App.class)
class AppSpecIT extends Specification {

    @Autowired
    WebApplicationContext context

    def "Should boot up without errors"() {
        expect: "web application context exists"
        context != null
    }

}