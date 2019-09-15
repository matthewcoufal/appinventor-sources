// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.runtime;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.ComponentConstants;
import com.google.appinventor.components.common.YaVersion;


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
    private Drawable buttonIcon;
    private String buttonText;
    private TabLayout.Tab tabButton;

    private static final String LOG_TAG = "Tab";

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