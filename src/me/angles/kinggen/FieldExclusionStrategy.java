package me.angles.kinggen;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.SerializedName;

public class FieldExclusionStrategy implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) { //i don't know if there's a better way lol
        return fieldAttributes.getAnnotations().stream().noneMatch((annotation -> annotation.annotationType() == SerializedName.class));
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}
