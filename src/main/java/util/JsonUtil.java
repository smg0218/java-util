package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JsonUtil {
    public static void responseJson(Object dto, HttpServletResponse response) {
        try {
            //JSON 형태의 응답 생성
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(dto);

            //응답 설정
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            response.getWriter().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 맨 처음에 있는 정보가 BOM일 경우 지워주는 메서드
    public static String removeBOM(String str) {
        if(str.startsWith("\uFEFF"))
            str = str.substring(1);

        return str;
    }

    // dto를 aws bouncer의 payload로 변환해주는 메서드
    public static Map<String, Object> convertDtoToPayload(Object dto) throws Exception {
        if (dto == null) return Collections.emptyMap();

        Map<String, Object> payload = new HashMap<>();
        Field[] fields = dto.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                payload.put(field.getName(), field.get(dto));
            } catch (IllegalAccessException e) {
                throw new RuntimeException("필드 접근 오류", e);
            }
        }

        return payload;
    }
}
