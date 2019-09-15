// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.runtime;

import android.support.design.widget.TabLayout;
import android.view.View;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;
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
public class TabArrangement extends AndroidViewComponent {
    private TabLayout view;
    private Tab[] tabs;
    private int selectedIndex;

    private static final String LOG_TAG = "TabArrangement";

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
        container.$add(this);
    }

    @Override
    public View getView() {
        return view;
    }
}
