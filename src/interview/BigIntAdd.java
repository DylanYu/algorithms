package interview;

/**
 * Add operation on positive big integers
 * 
 * @author Dongliang Yu
 *
 */
public class BigIntAdd {
    public static String add(String n1, String n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        if (n2.length() > n1.length()) {
            String tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        char[] arr1 = n1.toCharArray();
        char[] arr2 = n2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i = len1-1;
        int j = len2-1;
        int carry = 0;
        while  ( j >= 0) {
            int a = arr1[i] - '0';
            int b = arr2[j] - '0';
            int sum = a + b + carry;
            arr1[i] = (char) ((sum % 10) + '0');
            carry = sum / 10;
            i--;
            j--;
        }
        while (i >= 0 && carry == 1) {
            int a = arr1[i] - '0';
            int sum = a + carry;
            arr1[i] = (char) ((sum % 10) + '0');
            carry = sum / 10;
            i--;
        }
        if (carry == 1) {
            StringBuffer sb = new StringBuffer();
            sb.append('1');
            sb.append(arr1, 0, len1);
            return sb.toString();
        } else {
            String rst = new String(arr1);
            return rst;
        }
    }
    
    public static void main(String[] args) {
        String n1 = "111";
        String n2 = "9999999";
        System.out.println(add(n1, n2));
    }
}
