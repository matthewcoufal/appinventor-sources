// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client.editor.simple.components;

import com.google.appinventor.client.editor.simple.SimpleEditor;

/**
 * Mock TabArrangement component.
 *
 * @author yc2296@cornell.edu (Claire Yuqing Cui)
 */
public class MockTabArrangement extends MockVisibleComponent {
    /**
     * Component type name.
     */
    public static final String TYPE = "TabArrangement";

    /**
     * Creates a new MockTab component.
     *
     * @param editor  editor of source file the component belongs to
     */
    public MockTabArrangement(SimpleEditor editor) {
        super(editor, TYPE, images.circle());
    }
}