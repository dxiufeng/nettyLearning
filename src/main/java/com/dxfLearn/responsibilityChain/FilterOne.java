package com.dxfLearn.responsibilityChain;

public class FilterOne implements Filter {
    @Override
    public void doFilter() {
        System.out.println("FilterOne");
    }
}



class FilterTwo implements Filter{


    @Override
    public void doFilter() {
        System.out.println("FilterTwo");
    }
}



class FilterThree implements Filter{


    @Override
    public void doFilter() {
        System.out.println("FilterThree");
    }
}
