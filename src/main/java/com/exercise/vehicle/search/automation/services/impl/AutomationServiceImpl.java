package com.exercise.vehicle.search.automation.services.impl;

import com.exercise.vehicle.search.automation.constants.MimeTypes;
import com.exercise.vehicle.search.automation.exception.AutomationServiceException;
import com.exercise.vehicle.search.automation.model.FileDetail;
import com.exercise.vehicle.search.automation.services.IAutomationService;
import com.exercise.vehicle.search.automation.utils.AutomationUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by muhdk on 19/12/2017.
 */
public class AutomationServiceImpl implements IAutomationService {
    //loggers
    private static final Logger LOG = LoggerFactory.getLogger(AutomationServiceImpl.class);

    /**
     * Scans the directory with the files.
     *
     * @param path (Input path where the files are resided)
     * @return
     * @throws AutomationServiceException
     */
    @Override
    public List<FileDetail> scanDirectory(final String path) throws AutomationServiceException {

        //if its null then throw argument exception
        Validate.notNull(path, "Provide the file path");
        LOG.info("Scanning Directory for the path {}", path);

        List<FileDetail> fileDetails = new ArrayList<>();

        try {
            final Collection<File> files = FileUtils.listFiles(new File(path), null, false);

            LOG.debug("Files {}", files);
            //stream through the files
            files.forEach(f -> {

                //get mime type
                final String mimeType = AutomationUtils.getMimeType(f);
                //get file extension
                final String extension = FilenameUtils.getExtension(f.getName());

                //construct file detail and add to the list
                fileDetails.add(new FileDetail(f.getName(), mimeType, f.length(), extension));
            });
            return fileDetails;
        } catch (Exception e) {
            LOG.error("Error getting files from the directory :" + path, e);
            throw new AutomationServiceException("Error getting files from the directory :" + path, e);
        }
    }

    @Override
    public List<File> retrieveFiles(final String path, MimeTypes... mimeTypes) throws AutomationServiceException {
        //validate the input first
        Validate.notNull(path, "Provide the file path");
        Validate.notEmpty(mimeTypes, "At least one MimeType is required.");

        LOG.info("Retrieving files from Directory : {} for the mime types {} ", path, mimeTypes);
        //flatten the mime types to check
        final List<String> mimeTypesList = Arrays.stream(mimeTypes).flatMap(m -> Arrays.stream(m.getMimeTypes())).collect(Collectors.toList());
        final List<String> extensions = Arrays.stream(mimeTypes).flatMap(m -> Arrays.stream(m.getExtensions())).collect(Collectors.toList());

        LOG.info("File mime types to check {}", mimeTypesList);

        final Collection<File> files = FileUtils.listFiles(new File(path), null, false);

        LOG.debug("Files loaded from the directory: {}", files);

        //filter files based on the mime type provided as input
        final List<File> filteredFiles = files.stream()
                .filter(f ->

                        //if mime types and extension matches
                        mimeTypesList.contains(AutomationUtils.getMimeType(f)) && extensions.contains(FilenameUtils.getExtension(f.getName()))


                ).collect(Collectors.toList());
        return filteredFiles;


    }
}
