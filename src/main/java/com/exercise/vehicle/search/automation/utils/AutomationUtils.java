package com.exercise.vehicle.search.automation.utils;

import sun.nio.fs.DefaultFileTypeDetector;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by muhdk on 19/12/2017.
 */
public class AutomationUtils {


    /**
     * This method gets the mime type from the file.
     *
     * @param file (The input file)
     * @return
     * @throws IOException
     */
    public static String getMimeType(final File file) {
        try {
            return DefaultFileTypeDetector.create().probeContentType(Paths.get(file.toURI()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
