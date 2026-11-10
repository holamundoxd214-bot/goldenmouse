package com.google.errorprone.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value={ElementType.CONSTRUCTOR, ElementType.METHOD}) @public interface RestrictedApi {
    String allowedOnPath();

    Class[] allowlistAnnotations();

    Class[] allowlistWithWarningAnnotations();

    String explanation();

    String link();
}

