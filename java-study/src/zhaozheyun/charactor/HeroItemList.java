package com.zhaozheyun.charactor;

import com.zhaozheyun.property.Item;

import java.util.ArrayList;
import java.util.Collection;

public class HeroItemList extends ArrayList {
    public boolean canAdd(Object o) {
        return o instanceof Hero || o instanceof Item;
    }

    @Override
    public boolean add(Object o) {
        return this.canAdd(o) && super.add(o);
    }

    @Override
    public void add(int index, Object element) {
        if (this.canAdd(element)) {
            super.add(index, element);
        }
    }
}
