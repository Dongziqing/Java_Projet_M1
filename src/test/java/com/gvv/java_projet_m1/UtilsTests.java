package com.gvv.java_projet_m1;

import com.gvv.utils.PdfUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class UtilsTests {

    @Test
    public void pdfOutTest() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("nameBuyer", "xx");
        map.put("nameSeller", "xxx");
        map.put("dateSelle2", "xxxxx");
        Map<String,Object> o = new HashMap<>();
        o.put("datemap",map);
        PdfUtils.pdfOut(o);
    }
}
