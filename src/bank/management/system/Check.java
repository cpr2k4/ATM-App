package bank.management.system;
import java.util.*;
public class Check {

    public boolean check(String s1) {
        String s;
        boolean flag=false;
        s = s1;
        if (s1.length() > 4) {
            flag = true;
            return flag;
        }
        else {
            char ch[] = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(ch[i]))
                    flag = false;
                else {
                    flag = true;
                    break;
                }
            }
            return flag;
        }
    }
}