package com.exercise.vehicle.search.automation.services;

import com.exercise.vehicle.search.automation.constants.MimeTypes;
import com.exercise.vehicle.search.automation.exception.AutomationServiceException;
import com.exercise.vehicle.search.automation.model.FileDetail;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by muhdk on 19/12/2017.
 */
public interface IAutomationService {
    List<FileDetail> scanDirectory(String path) throws IOException, AutomationServiceException;

    List<File> retrieveFiles(String path, MimeTypes... mimeTypes) throws AutomationServiceException;
}
