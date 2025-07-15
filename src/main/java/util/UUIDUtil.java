package util;

import java.util.UUID;

public class UUIDUtil {
    /**
     * 랜덤한 UUID를 생성해주는 메서드
     * @return 생성된 UUID
     */
    public static UUID makeUUID() {
        return UUID.randomUUID();
    }
}
