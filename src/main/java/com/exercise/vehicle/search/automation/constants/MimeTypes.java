package com.exercise.vehicle.search.automation.constants;

/**
 * Created by muhdk on 19/12/2017.
 */
public enum MimeTypes {

    //application/vnd.ms-excel is used for CSV when using WINDOWS
    CSV(new String[]{"application/vnd.ms-excel", "text/csv"}, new String[]{"csv"}),

    EXCEL(new String[]{"application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"},
            new String[]{"xls", "xlsx"});

    private final String[] mimeTypes;
    private final String[] extensions;

    MimeTypes(String[] mimeTypes, final String[] extensions) {
        this.mimeTypes = mimeTypes;
        this.extensions = extensions;

    }

    public String[] getMimeTypes() {
        return mimeTypes;
    }

    public String[] getExtensions() {
        return extensions;
    }
}
