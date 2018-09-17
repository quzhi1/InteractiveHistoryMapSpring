package com.quzhi1.controller;

import com.google.gson.Gson;
import com.quzhi1.csv.ImageLookupTableUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class IndexController {

    private final static Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
    private final static Map<String, String> imageLookupTable = ImageLookupTableUtil.loadImageLookupTable();
    private final static Gson gson = new Gson();
    private final static String imageLookupTableJson = gson.toJson(imageLookupTable);

    @GetMapping("/")
    public String index(Model m) {
        LOGGER.info("Map loaded");
        m.addAttribute("imageLookupTable", imageLookupTableJson);
        return "index";
    }
}
