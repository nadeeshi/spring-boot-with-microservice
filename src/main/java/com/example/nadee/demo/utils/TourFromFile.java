package com.example.nadee.demo.utils;

import com.example.nadee.demo.types.Difficulty;
import com.example.nadee.demo.types.Region;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class TourFromFile {

    // fields
    private String packageType, title, description, blurb, price, length, bullets,
            keywords, difficulty, region;

    public TourFromFile() {
    }

    //reader
    public static List<TourFromFile> read(String fileToImport) throws IOException {
        return new ObjectMapper()
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .readValue(new FileInputStream(fileToImport), new TypeReference<List<TourFromFile>>() {
                });
    }

    public String getPackageType() {
        return packageType;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBlurb() {
        return blurb;
    }

    public Integer getPrice() {
        return Integer.parseInt(price);
    }

    public String getLength() {
        return length;
    }

    public String getBullets() {
        return bullets;
    }

    public String getKeywords() {
        return keywords;
    }

    public Difficulty getDifficulty() {
        return Difficulty.valueOf(difficulty);
    }

    public Region getRegion() {
        return Region.findByLabel(region);
    }
}
