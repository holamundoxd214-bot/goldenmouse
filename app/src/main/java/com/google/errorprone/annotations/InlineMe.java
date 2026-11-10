package com.google.errorprone.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented @Target(value={ElementType.METHOD, ElementType.CONSTRUCTOR}) @public interface InlineMe {
    String[] imports();

    String replacement();

    String[] staticImports();
}

