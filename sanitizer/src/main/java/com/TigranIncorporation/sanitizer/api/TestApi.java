package com.TigranIncorporation.sanitizer.api;

import com.TigranIncorporation.sanitizer.model.TestObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestApi {
    @GetMapping
    public TestObject test(){
        return new TestObject("One","Two","Three","Four");
    }
}
