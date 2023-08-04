package com.example.nadee.demo.types;

public enum Region {

    CENTRAL_COAST("Central Coast"),
    SOUTHERN_CALIFORNIA("Southern California"),
    NORTHERN_CALIFORNIA("Northern California"),
    VARIES("Varies");

    private String label;

    Region(String label) {
        this.label = label;
    }

    public static Region findByLabel(String byLabel) {
        for(Region region: Region.values()) {
            if(region.label.equalsIgnoreCase(byLabel)) {
                return region;
            }
        }

        return null;
    }
}
