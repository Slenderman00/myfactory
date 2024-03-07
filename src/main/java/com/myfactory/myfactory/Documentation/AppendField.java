package com.myfactory.myfactory.Documentation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.METHOD,
})
@Repeatable(AppendFields.class)
public @interface AppendField {
    String name() default "";
    String description() default "";
    Class<?> type() default Object.class;
}