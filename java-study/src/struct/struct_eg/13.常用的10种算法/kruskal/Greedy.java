package com.bjpowernode.kruskal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class Greedy {

    public static void main(String[] args) {

        /**
         * 创建一个集合，areaList,存储城市
         */
        ArrayList<String> areaList = new ArrayList<>();
        areaList.add("北京");
        areaList.add("上海");
        areaList.add("天津");
        areaList.add("广州");
        areaList.add("深圳");
        areaList.add("成都");
        areaList.add("杭州");
        areaList.add("大连");

        HashSet<String> area1 = new HashSet<>();
        area1.add("北京");
        area1.add("上海");
        area1.add("天津");

        HashSet<String> area2 = new HashSet<>();
        area2.add("广州");
        area2.add("北京");
        area2.add("深圳");

        HashSet<String> area3 = new HashSet<>();
        area3.add("成都");
        area3.add("上海");
        area3.add("杭州");


        HashSet<String> area4 = new HashSet<>();
        area4.add("上海");
        area4.add("天津");


        HashSet<String> area5 = new HashSet<>();
        area5.add("杭州");
        area5.add("大连");

        /**
         * 电台所覆盖城市的范围
         */
        HashMap<String,HashSet<String>> broadcasts = new HashMap<>();
        broadcasts.put("K1",area1);
        broadcasts.put("K2",area2);
        broadcasts.put("K3",area3);
        broadcasts.put("K4",area4);
        broadcasts.put("K5",area5);

        /**
         * 用户存储符合要求的电台
         */
        ArrayList<String> keyList = new ArrayList<>();
        //用于存储每一次遍历areaList交集最多电台
        String key = null;

        //临时用来存储电台所覆盖的城市
        HashSet<String> temp = new HashSet<>();
        //循环条件是areaList没有城市数据，说明每个城市都被覆盖
        while (!areaList.isEmpty()){

            for (String broadcastsKey : broadcasts.keySet()) {
                    //先进行清空
                    temp.clear();
                    temp.addAll(broadcasts.get(broadcastsKey));
                    //retainAll  可以取交集
                    temp.retainAll(areaList);
                    if (temp.size()>0 && (key == null || temp.size()>broadcasts.get(key).size())){
                        key = broadcastsKey;
                    }
            }

            if (key !=null){
                keyList.add(key);
                areaList.removeAll(broadcasts.get(key));
                key = null;
            }

        }

        System.out.println(keyList.toString());

    }

}
