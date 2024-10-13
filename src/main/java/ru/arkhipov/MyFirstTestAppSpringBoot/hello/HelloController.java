package ru.arkhipov.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HelloController {
    private ArrayList<String> stringList = new ArrayList<>();
    private HashMap<Integer, String> stringMap = new HashMap<>();

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
            defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "string") String string) {
        if (stringList.isEmpty()) stringList = new ArrayList<>();
        stringList.add(string);
        return "Array: " + stringList;
    }

    @GetMapping("/show-array")
    public String showArrayList() {
        return "Elements: " + stringList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "string") String string) {
        if (stringMap.isEmpty()) {
            stringMap = new HashMap<>();
        }
        stringMap.put(stringMap.size() + 1, string);
        return "Map: " + stringMap;
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        return "Map element: " + stringMap;
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        return "Array: " + stringList.size() + " Hash: " + stringMap.size();
    }
}
