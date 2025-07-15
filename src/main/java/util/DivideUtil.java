package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DivideUtil {

    /**
     * 쉼표(,)가 들어가있는 String 문자열을 쉼표를 기준으로 나눠서 배열에 담아 리턴해주는 메서드
     * @param str ,이 들어가 있는 문자열 String
     * @return str에서 ,를 기준으로 나눠서 String배열로 리턴
     */
    public static String[] divideString(String str) {
        // 공백을 제거
        str = str.replaceAll("\\s+", "");
        // String 배열에 담아서 리턴
        return str.split(",");
    }

    /**
     * 쉼표(,)가 들어가있는 숫자만 들어간 문자열을 쉼표 기준으로 나눠서 Long 형태의 리스트에 담아 리턴해주는 메서드
     * @param str ,이 들어가 있고 숫자만 들어있는 문자열 String
     * @return str에서 ,를 기준으로 나눠서 Long 리스트로 리턴
     */
    public static List<Long> divideStringReturnLongList(String str) {

        // 공백을 제거
        str = str.replaceAll("\\s+", "");
        // String 배열에 담아서 리턴
        String[] strs = str.split(",");

        return Arrays.stream(strs)
                .mapToLong(Long::parseLong).boxed()
                .collect(Collectors.toList());
    }

    /**
     * 확장자를 제거하는 메서드
     * @param str 확장자 제거를 원하는 확장자가 담김 파일명
     * @return 확장자가 제거된 파일명
     */
    public static String removeExtension(String str) {
        int dotIndex = str.lastIndexOf('.');
        return  dotIndex != -1 ? str.substring(0, dotIndex) : str;
    }

    public static int floorToTens(int num) {
        return num - (num % 10);
    }
}
