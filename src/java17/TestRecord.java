package java17;

import com.google.common.collect.Maps;

import java.awt.*;
import java.util.Map;
import java.util.Objects;

public class TestRecord {
    public static void main(String[] args) {
        var p = new Point(1, 4);
        System.out.println(p);
        var q = new Point(2, 5);
        System.out.println(Objects.equals(p, q));

        Map<Point, Color> map = Maps.newHashMap();
        map.put(p, Color.BLACK);
        System.out.println(map);
    }
}
