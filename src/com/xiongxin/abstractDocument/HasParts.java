package com.xiongxin.abstractDocument;

import java.util.stream.Stream;

public interface HasParts extends Document {

    default Stream<Part> getParts() {
        return children(Property.PARTS.toString(), Part::new);
    }
}
