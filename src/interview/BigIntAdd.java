package interview;

/**
 * Add operation on positive big integers
 * 
 * @author Dongliang Yu
 *
 */
public class BigIntAdd {
    public static String add(String s1, String s2) {
        if (s1 == null && s2 == null) return "";
        if (s1 == null) return s2;
        if (s2 == null) return s1;
        int len1 = s1.length();
        int len2 = s2.length();
        //if (len1 == 0) return s2;
        //if (len2 == 0) return s1;
        int len = Math.max(len1, len2) + 1;
        int[] ret = new int[len];
        int i = len1-1;
        int j = len2-1;
        int k = len-1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int a = (i >= 0) ? s1.charAt(i--)-'0' : 0;
            int b = (j >= 0) ? s2.charAt(j--)-'0' : 0;
            int sum = a + b + carry;
            ret[k--] = sum % 10;
            carry = sum / 10;
        }
        ret[0] = carry;
        if (ret[0] == 0) k = 1;
        else k = 0;
        StringBuffer sb = new StringBuffer();
        while (k < len)
            sb.append(ret[k++]);
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String n1 = "111";
        String n2 = "9999999";
        System.out.println(add(n1, n2));
    }
}
