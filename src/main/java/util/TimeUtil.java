package util;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class TimeUtil {
    /**
     *
     * @param timeZone : 요청을 보낸 유저가 사는 지역
     * @return : 받은 parameter값을 바탕으로 전환한 ZoneId
     */
    public static ZoneId getZoneId(String timeZone) {
        if (timeZone == null || timeZone.isEmpty())
            return ZoneId.of("UTC");
        else
            return ZoneId.of(timeZone);
    }

    /**
     * `LocalDateTime`을 한국 표준시(KST)로 가정하여 `OffsetDateTime`을 반환합니다.
     * @param time : 주어진 시간
     * @return : 한국 표준시(KST)로 변환된 `OffsetDateTime`
     */
    public static OffsetDateTime getOffsetTimeFromKST(LocalDateTime time) {
        if (time == null) {
            return null;
        }
        ZoneId zoneId = ZoneId.of("Asia/Seoul");
        ZoneOffset zoneOffset = zoneId.getRules().getOffset(time);
        return OffsetDateTime.of(time, zoneOffset);
    }
}
