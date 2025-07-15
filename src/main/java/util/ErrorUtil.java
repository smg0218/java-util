package util;

public class ErrorUtil {
    /**
     * Exception의 클래스 이름만 추출하는 메서드
     * @param e 추출을 원하는 Exception
     * @return String 형태의 Exception 이름
     */
    public static String getOnlyName(Exception e) {
        String fullClassName = e.getClass().getName();
        return fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
    }
}
