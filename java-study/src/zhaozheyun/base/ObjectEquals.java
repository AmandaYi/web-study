package com.zhaozheyun.base;

import java.util.Objects;

public class ObjectEquals {
    String name = "";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjectEquals)) return false;
        ObjectEquals that = (ObjectEquals) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
