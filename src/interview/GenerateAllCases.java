package interview;

import java.util.LinkedList;
import java.util.List;

public class GenerateAllCases {
    // "0ab" -> ["0ab", "0aB", "0Ab", "0AB"]
    public List<String> generate(String s) {
        List<String> ret = new LinkedList<String>();
        generate(new StringBuilder(s), 0, ret);
        return ret;
    }
    
    private void generate(StringBuilder sb, int index, List<String> ret) {
        if (index == sb.length()) {
            ret.add(sb.toString());
            return;
        }
        generate(sb, index+1, ret);
        char c = sb.charAt(index);
        if (Character.isLowerCase(c)) {
            sb.setCharAt(index, (char) (c+'A'-'a'));
            generate(sb, index+1, ret);
            //sb.setCharAt(index, c);
        } else if (Character.isUpperCase(c)) {
            sb.setCharAt(index, (char) (c-'A'+'a'));
            generate(sb, index+1, ret);
            //sb.setCharAt(index, c);
        }
    }
    
    public static void main(String[] args) {
        String s = "0aB";
        List<String> ret = new GenerateAllCases().generate(s);
        for (String e : ret)
            System.out.println(e);
    }
}
