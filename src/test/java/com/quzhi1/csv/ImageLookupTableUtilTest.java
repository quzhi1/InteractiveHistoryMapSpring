package com.quzhi1.csv;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class ImageLookupTableUtilTest {

    @Test
    public void testTableLoad() {
        Map<String, String> table = ImageLookupTableUtil.loadImageLookupTable();
        Assert.assertEquals(table.get("1930.6"),
                            "https://farm2.staticflickr.com/1846/44211048931_ca0396756f_o.jpg");
    }

}
