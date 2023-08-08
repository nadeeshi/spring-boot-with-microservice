package com.example.nadee.demo;

import com.example.nadee.demo.service.TourPackageService;
import com.example.nadee.demo.service.TourService;
import com.example.nadee.demo.utils.TourFromFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * Here we are using In-memory H2 database.
 * Therefor we need to load the data each time when the application starts
 */
@SpringBootApplication
public class DemoApplicationWithCommandLineRunner implements CommandLineRunner {

    @Value("${demo.importDataFile}")
    private String importFile;

    @Autowired
    private TourPackageService tourPackageService;

    @Autowired
    private TourService tourService;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplicationWithCommandLineRunner.class, args);
    }

    /**
     * Set up the database request before the web request persist in order to data available before API calls
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        createTourPackages();
        long numOfTourPackages = tourPackageService.total();

        createTours(importFile);
        long numOfTours = tourService.total();
    }

    private void createTourPackages() {
        tourPackageService.createTourPackage("BC", "Backpack Cal");
        tourPackageService.createTourPackage("CC", "California Calm");
        tourPackageService.createTourPackage("CH", "California Hot springs");
        tourPackageService.createTourPackage("CY", "Cycle California");
        tourPackageService.createTourPackage("DS", "From Desert to Sea");
        tourPackageService.createTourPackage("KC", "Kids California");
        tourPackageService.createTourPackage("NW", "Nature Watch");
        tourPackageService.createTourPackage("SC", "Snowboard Cali");
        tourPackageService.createTourPackage("TC", "Taste of California");
    }

    /**
     * Create tour entities from an external data (Data.json) file
     * @param fileToImport
     * @throws IOException
     */
    private void createTours(String fileToImport) throws IOException {
        TourFromFile.read(fileToImport).forEach(importedTour ->
                tourService.createTour(importedTour.getTitle(),
                        importedTour.getDescription(),
                        importedTour.getBlurb(),
                        importedTour.getPrice(),
                        importedTour.getLength(),
                        importedTour.getBullets(),
                        importedTour.getKeywords(),
                        importedTour.getPackageType(),
                        importedTour.getDifficulty(),
                        importedTour.getRegion()));
    }
}
