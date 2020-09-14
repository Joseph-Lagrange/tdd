import java.math.BigDecimal;
import java.util.Arrays;

public class Mommifier {

    public String convert(String calculateStr) {
        int vowelNum = 0;
        int[] flag = new int[calculateStr.length()];
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < calculateStr.length(); i++) {
            for (char vowel : vowels) {
                if (calculateStr.charAt(i) == vowel) {
                    vowelNum++;
                    flag[i] = 1;
                }
            }
        }
        if (vowelNum != 0 && calculate(vowelNum, calculateStr.length()) > 30) {
            return insert(calculateStr, flag);
        }
        return calculateStr;
    }

    private String insert(String calculateStr, int[] flag) {
        StringBuilder insertedStr = new StringBuilder();
        for (int i = 0; i < flag.length; i++) {
            insertedStr.append(calculateStr.charAt(i));
            if (flag[i] == 1 && i + 1 < flag.length && flag[i+1] == 1) {
                insertedStr.append("mommy");
            }
        }
        return insertedStr.toString();
    }

    private int calculate(int vowelNum, int length) {
        return (int)((new BigDecimal((float) vowelNum / length).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue())*100);
    }
}
