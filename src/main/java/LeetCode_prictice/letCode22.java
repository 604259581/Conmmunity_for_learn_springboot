package LeetCode_prictice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class letCode22 {
    public static List<String> generateParenthesis(int j) {
        List<String> list = new ArrayList<>();
        generateAll(list,"",0,0,j);
        return list;
    }

    private static void generateAll(List<String> list, String s, int open, int close, int n) {
        if(s.length()==n*2){
            list.add(s);
            return;
        }
        if(open<n){
            generateAll(list,s+'(',open+1,close,n);
        }
        if(close<open){
            generateAll(list,s+')',open,close+1,n);
        }
    }

    public static void main(String[] args){
        int j = 3;
        List<String> list = generateParenthesis(j);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
