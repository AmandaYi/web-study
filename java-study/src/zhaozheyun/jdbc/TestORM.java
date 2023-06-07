package com.zhaozheyun.jdbc;

import java.util.ArrayList;

public class TestORM {
    public static void main (String[] args) {

        Hero h = new Hero();

//        h.setId();
        h.setName("剑圣");
        h.setHp(100.10f);
        h.setDamage(10);

        HeroORM heroORM = new HeroORM();
//        heroORM.add(h);
        Hero h2 = new Hero();
        h2.setId(13);
        heroORM.delete(h2);

        Hero h3 = new Hero();
        h3.setId(14);
        h3.setName("无极剑圣");
        h3.setHp(100.10f);
        h3.setDamage(10);
        heroORM.update(h3);

        ArrayList<Hero> list = new ArrayList<Hero>();

        list = heroORM.list();
        System.out.println(list);

    }
}
