package com.xiongxin.abstractDocument;

import java.util.Map;

public class Part extends AbstractDocument
        implements HasPrice, HasType, HasModel {


    protected Part(Map<String, Object> properties) {
        super(properties);
    }
}
