package com.shdosh.fav;

import java.util.Scanner;

public class Favorite {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(n);
        int[] fav = new int[n];
        for(int i = 0; i < n; i++){
            fav[i]=scan.nextInt();
            System.out.println(fav[i]);
        }
        
    }
}
