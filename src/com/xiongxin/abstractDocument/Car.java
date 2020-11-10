package com.xiongxin.abstractDocument;

import java.util.Map;

public class Car extends AbstractDocument
    implements HasModel, HasPrice, HasParts {

    protected Car(Map<String, Object> properties) {
        super(properties);
    }
}
