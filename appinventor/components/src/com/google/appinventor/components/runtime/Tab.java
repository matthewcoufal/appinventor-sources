// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2019 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0


package com.google.appinventor.components.runtime;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;

import android.util.Log;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.ComponentConstants;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.runtime.util.MediaUtil;

import java.io.IOException;

/**
 * A button along with a vertical arrangement.
 *
 * @author yc2296@cornell.edu (Claire Yuqing Cui)
 */

@DesignerComponent(version = YaVersion.TAB_COMPONENT_VERSION,
        description = "<p>A button which upon press will display vertically displayed components. </p>",
        category = ComponentCategory.LAYOUT,
        iconName = "images/tab.png")
@SimpleObject
public class Tab extends HVArrangement {
    private String buttonIconPath;

    // This is the Drawable corresponding to the buttonIconPath property.
    // If a buttonIconPath has never been set or if the most recent buttonIconPath
    // could not be loaded, this is null.
    private Drawable buttonIconDrawable;
    private String buttonText;
    private TabLayout.Tab tabButton;

    private static final String LOG_TAG = "Tab";

    /**
     * Returns the text displayed by the tab button.
     *
     * @return  button text
     */
    @SimpleProperty(
            description = "The text displayed by the tab button.")
    public String ButtonText() {
        return buttonText;
    }

    /**
     * Specifies the text displayed by the tab button.
     *
     * @param text  new caption for tab button
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING,
            defaultValue = "Text")
    @SimpleProperty
    public void ButtonText(String text) {
        buttonText = text;
        tabButton.setText(buttonText);
    }

    /**
     * Returns the path of the tab button's icon.
     *
     * @return  the path of the tab button's icon.
     */
    @SimpleProperty(
            description = "Icon to display on tab.")
    public String ButtonIconPath() {
        return buttonIconPath;
    }

    /**
     * Specifies the path of the tab button's icon.
     *
     * <p/>See {@link MediaUtil#determineMediaSource} for information about what
     * a path can be.
     *
     * @param path  the path of the tab button's icon
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_ASSET,
            defaultValue = "")
    @SimpleProperty(description = "Specifies the path of the image of the %type%. ")
    public void ButtonIconPath(String path) {
        // If it's the same as on the prior call and the prior load was successful,
        // do nothing.
        if (path.equals(buttonIconPath) && buttonIconDrawable != null) {
            return;
        }

        buttonIconPath = (path == null) ? "" : path;

        // Clear the prior background image.
        buttonIconDrawable = null;

        // Load image from file.
        if (buttonIconPath.length() > 0) {
            try {
                buttonIconDrawable = MediaUtil.getBitmapDrawable(container.$form(), buttonIconPath);
            } catch (IOException ioe) {
                // TODO(user): Maybe raise Form.ErrorOccurred.
                Log.e(LOG_TAG, "Unable to load " + buttonIconPath);
                // Fall through with a value of null for buttonIconDrawable.
            }
        }

        // Update the appearance based on the new value of buttonIconDrawable.
        updateAppearance();
    }

    // Update appearance based on values of buttonIconDrawable, backgroundColor and shape.
    // Images take precedence over background colors.
    private void updateAppearance() {
        //TODO
    }

    public Tab(ComponentContainer container) {
        super(container, ComponentConstants.LAYOUT_ORIENTATION_VERTICAL,
                ComponentConstants.NONSCROLLABLE_ARRANGEMENT);

        // create tab button
        TabArrangement arrangement = (TabArrangement) container;
        TabLayout layout = (TabLayout) arrangement.getView();
        tabButton = layout.newTab ();
    }

    public TabLayout.Tab getTabButton() {
        return tabButton;
    }
}