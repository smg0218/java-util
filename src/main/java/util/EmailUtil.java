package util;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Random;

public class EmailUtil {

    /**
     * 6자리의 랜덤한 숫자를 생성해주는 메서드
     * @return String 형태의 생성된 6자리의 랜덤한 숫자
     */
    public static String generateVerificationCode() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }

    /**
     * 메일을 보내는 메서드
     * @param mailSender 메일을 보내는 사람
     * @param email 메일을 받을 주소
     * @param subject 메일의 제목
     * @param text 메일의 내용
     */
    public static void sendEmail(JavaMailSender mailSender, String email, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }
}
