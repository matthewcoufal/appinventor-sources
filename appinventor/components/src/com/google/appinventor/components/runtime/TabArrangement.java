// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2019 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0


package com.google.appinventor.components.runtime;

import android.support.design.widget.TabLayout;
import android.view.View;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.common.YaVersion;

/**
 * An arrangement for tab bars.
 *
 * @author yc2296@cornell.edu (Claire Yuqing Cui)
 */

@DesignerComponent(version = YaVersion.TABARRANGEMENT_COMPONENT_VERSION,
        description = "<p>A tab bar where different tabs can be selected to display different screens </p>",
        category = ComponentCategory.LAYOUT,
        iconName = "images/tabBar.png")
@SimpleObject
@UsesPermissions(permissionNames = "android.permission.INTERNET")
public class TabArrangement extends AndroidViewComponent {
    private TabLayout view;
    private Tab[] tabs;
    private int selectedIndex;
    private int backgroundColor;
    private int unselectedColor;
    private int selectedColor;

    private static final String LOG_TAG = "TabArrangement";

    /**
     * Returns the tab bar's background color as an alpha-red-green-blue
     * integer.
     *
     * @return  background RGB color with alpha
     */
    @SimpleProperty(
            description = "The tab bar's background color")
    public int BackgroundColor() {
        return backgroundColor;
    }

    /**
     * Specifies the tab bar's background color as an alpha-red-green-blue
     * integer.  If the parameter is {@link Component#COLOR_DEFAULT}, the
     * original beveling is restored.
     *
     * @param argb background RGB color with alpha
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR,
            defaultValue = Component.DEFAULT_VALUE_COLOR_BLACK)
    public void BackgroundColor(int argb) {
        backgroundColor = argb;
        updateAppearance();
    }

    /**
     * Returns the color for unselected tabs as an alpha-red-green-blue
     * integer.
     *
     * @return RGB color with alpha
     */
    @SimpleProperty(
            description = "The tab bar's color for unselected tabs.")
    public int UnselectedColor() {
        return unselectedColor;
    }

    /**
     * Specifies the color for unselected tabs as an alpha-red-green-blue
     * integer.  If the parameter is {@link Component#COLOR_DEFAULT}, the
     * original beveling is restored.
     *
     * @param argb RGB color with alpha
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR,
            defaultValue = Component.DEFAULT_VALUE_COLOR_GRAY)
    public void UnselectedColor(int argb) {
        unselectedColor = argb;
        updateAppearance();
    }

    /**
     * Returns the color for the selected tab as an alpha-red-green-blue
     * integer.
     *
     * @return RGB color with alpha
     */
    @SimpleProperty(
            description = "The tab bar's color for the selected tab.")
    public int SelectedColor() {
        return selectedColor;
    }

    /**
     * Specifies the color for the selected tab as an alpha-red-green-blue
     * integer.  If the parameter is {@link Component#COLOR_DEFAULT}, the
     * original beveling is restored.
     *
     * @param argb RGB color with alpha
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR,
            defaultValue = Component.DEFAULT_VALUE_COLOR_WHITE)
    public void SelectedColor(int argb) {
        selectedColor = argb;
        updateAppearance();
    }

    // Update appearance based on values of backgroundImageDrawable, backgroundColor and shape.
    // Images take precedence over background colors.
    private void updateAppearance() {
        //TODO
    }

    /**
     * Creates a new TabArrangement component.
     *
     * @param container container, component will be placed in
     */
    public TabArrangement(ComponentContainer container) {
        super(container);
        view = new TabLayout(container.$context());
        for (Tab tab : tabs) {
            view.addTab(tab.getTabButton());
        }
        //view.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener());
        container.$add(this);
    }

    @Override
    public View getView() {
        return view;
    }

    public void addTab(Tab tab) {
        TabLayout.Tab tabButton = tab.getTabButton();
        view.addTab(tabButton);
    }

    public void removeTab(Tab tab) {
        TabLayout.Tab tabButton = tab.getTabButton();
        view.removeTab(tabButton);
    }
}
