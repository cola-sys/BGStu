package com.kola.Algorithm;

public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(12, 45));
        System.out.println(gcd(45, 12));
    }

    public static int gcd(int a,int b){
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);
    }
}
