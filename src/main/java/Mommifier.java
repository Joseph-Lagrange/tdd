import java.util.Objects;
import java.util.stream.Stream;

class Mommifier {

    private static final int RequestNumber = 30;
    private static final String InsertString = "mommy";
    private static final String VowelString = "aeiou";

    String convert(String convertStr) {
        int vowelNum = 0;
        int[] indexArr = new int[convertStr.length()];
        for (int i = 0; i < convertStr.length(); i++) {
            String charStr = String.valueOf(convertStr.charAt(i));
            boolean isVowel = Stream.of(VowelString.split("")).anyMatch(v -> Objects.equals(v, charStr));
            if (isVowel) {
                vowelNum++;
                indexArr[i] = 1;
            }
        }
        if (vowelNum > 1 && isVaild(vowelNum, convertStr.length())) {
            return insert(convertStr, indexArr);
        }
        return convertStr;
    }

    private String insert(String convertStr, int[] flag) {
        StringBuilder insertedStr = new StringBuilder();
        for (int i = 0; i < flag.length; i++) {
            insertedStr.append(convertStr.charAt(i));
            if (flag[i] == 1 && i + 1 < flag.length && flag[i+1] == 1) {
                insertedStr.append(InsertString);
            }
        }
        return insertedStr.toString();
    }

    private boolean isVaild(int vowelNum, int length) {
        return ((float) vowelNum / length) * 100 > RequestNumber;
    }
}
