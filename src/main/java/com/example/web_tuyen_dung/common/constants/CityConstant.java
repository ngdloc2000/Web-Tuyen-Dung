package com.example.web_tuyen_dung.common.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CityConstant {
    public static Map<Integer, String> CITITES =
            Collections.unmodifiableMap(new HashMap<Integer, String>() {
                {
                    put(0, "Hà Nội");
                    put(1, "Hà Nam");
                    put(2, "Hồ Chí Minh");
                    put(3, "Đà Nẵng");
                    put(4, "Hải Phòng");
                }
            });
}
