package util;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
    /**
     *  파일의 용량을 확인하는 메서드
     * @param file : 용량을 확인하고 싶은 파일
     * @param size : 최대 파일 사이즈(단위 : MB)
     * @return : 크면 True, 작으면 False 리턴
     */
    public static boolean checkFileSize(MultipartFile file, long size) {
        return file.getSize() >= size * 1024 * 1024;
    }

    /**
     * 파일의 크기를 확인하여 kb, mb로 변환해주는 메서드
     * @param bytes 확인을 원하는 파일의 길이[long]
     * @return 단위를 포함한 파일 사이즈
     */
    public static String getFormattedFileSize(long bytes) {
        final long KB = 1024;
        final long MB = KB * 1024;

        if (bytes < KB) {
            return "1 KB"; // 최소 단위 보정
        } else if (bytes < MB) {
            long kb = bytes / KB;
            return kb + " KB";
        } else {
            double mb = (double) bytes / MB;
            return String.format("%.2f MB", mb);
        }
    }
}
