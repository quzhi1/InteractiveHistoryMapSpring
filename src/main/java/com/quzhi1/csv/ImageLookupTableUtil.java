package com.quzhi1.csv;

import static org.apache.logging.log4j.core.util.Loader.getClassLoader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ImageLookupTableUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(ImageLookupTableUtil.class);
    private static final String IMAGE_LOOKUP_TABLE_LOC = "csv/TitleLookupTableFile.csv";

    public static Map<String, String> loadImageLookupTable() {
        try {
            Reader in = new InputStreamReader(
                getClassLoader().getResourceAsStream(IMAGE_LOOKUP_TABLE_LOC), StandardCharsets.UTF_8);
            CSVParser parser = CSVFormat.EXCEL.withHeader().parse(in);
            return StreamSupport.stream(parser.spliterator(), true)
                .collect(Collectors.toMap(csvRecord -> csvRecord.get("file_name").trim().replace(".jpg", ""),
                                          csvRecord -> csvRecord.get("url").trim()));
        } catch (IOException e) {
            LOGGER.error("Caught IOException when loading imageLookupTable csv", e);
            return Collections.emptyMap();
        }
    }

    public static String mapToStr(final Map<String, String> map) {
        return map.entrySet().stream()
            .map(entry -> entry.getKey() + ": " + entry.getValue())
            .collect(Collectors.joining("\n"));
    }
}
