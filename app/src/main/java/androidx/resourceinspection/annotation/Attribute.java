package androidx.resourceinspection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.SOURCE) @Target(value={ElementType.METHOD}) @public interface Attribute {
    @Retention(value=RetentionPolicy.SOURCE) @Target(value={}) @public interface IntMap {
        int mask();

        String name();

        int value();
    }

    IntMap[] intMapping();

    String value();
}

