package com.ayo.zbd.app.freemarker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMarkerTest {

    public static void main(String[] args) {

        String dir = "resource/views";

        Map data = new HashMap();
        data.put("intro", "FreeMarker Test");
        data.put("x", 3.45675);
        data.put("mayBeNul", null);

        data.put("names", new String[]{
                "王二","张三",
        });

        Map<String, String> namesMap = new HashMap<>();
        namesMap.put("a", "王二");
        namesMap.put("b", "张三");
        namesMap.put("c", "李四");
        data.put("namesMap", namesMap);

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        animals.add(new Animal());
        animals.add(new Animal());
        animals.add(new Animal());
        animals.add(new Animal());
        data.put("animals", animals);

        String result = FreeMarker.process(dir, "test/freemarker.ftl", data);
        System.out.println(result);
    }

    public static class Animal{
        public String name = "猫狗树懒";
        public double price = 100.78;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;
        }

    }

}
