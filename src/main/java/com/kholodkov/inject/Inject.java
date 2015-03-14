package com.kholodkov.inject;

import java.lang.annotation.*;

/**
 * Spring#7-1 32:42
 */
@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
    public String value();
}
