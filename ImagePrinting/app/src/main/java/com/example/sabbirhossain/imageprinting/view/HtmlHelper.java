package com.example.sabbirhossain.imageprinting.view;

import android.content.Context;
import android.support.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;

/**
 * Process html, Retrieve html template from
 * asset replace keys and produce print ready html
 */
class HtmlHelper {

    private final Context context;

    /**
     * Constructor
     *
     * @param context
     */
    HtmlHelper(Context context) {
        this.context = context;
    }

    /**
     * Takes template file name, retrieve it from asset and
     * replace keys with values and return
     *
     * @param fileName Name of the template file in assets folder
     * @return Print ready html
     * @throws IOException if template file can not be retrieve
     */
    String getHtml(String fileName) throws IOException {
        return getStringFromHtmlTemplateAsset(fileName);
    }

    /**
     * Get Html template from asset; read it and
     * return converted string
     *
     * @param fileName Name of the template
     * @return Converted string
     * @throws IOException if can not access file
     */
    @NonNull
    private String getStringFromHtmlTemplateAsset(String fileName) throws IOException {
        InputStream inputStream = context.getAssets().open(fileName);
        int size = inputStream.available();

        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        inputStream.close();

        return new String(buffer);
    }
}
