package com.dxfLearn.lambda;


import java.util.*;

public class TestLambda {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("使用Lamdba的方式，筛选出 hp>100 && damange<50的英雄");
        // filter(heros,h->h.hp>100 && h.damage<50);
        Comparator<Hero> heroComparator = new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {


                if (o1.damage > o2.damage)
                    return -1;
                else

                    return 1;
            }

        };

        heros.sort(heroComparator);
        System.out.println(heros);

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Collections.sort(list, (a, b) -> {
            if (a > b)
                return -1;
            else
                return 1;

        });
        System.out.println(list);


    }


}
