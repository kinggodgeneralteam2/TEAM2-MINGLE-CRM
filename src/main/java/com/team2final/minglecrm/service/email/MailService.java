package com.team2final.minglecrm.service.email;

import com.team2final.minglecrm.persistence.dao.RedisDao;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MailService {

    @Value("${spring.mail.username}")
    private String emailFrom;

    private final JavaMailSender mailSender;
    private final RedisDao redisDao;

    public static String createAuthCode() {
        StringBuilder key = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < 8; i++) { // 인증코드 8자리
            int index = rand.nextInt(3); // 0~2 까지 랜덤

            switch (index) {
                case 0:
                    key.append((char)(rand.nextInt(26) + 97));
                    //  a ~ z (e.g., 1 + 97 = 98 => (char)98 = 'b')
                    break;
                case 1:
                    key.append((char)(rand.nextInt(26) + 65));
                    //  A ~ Z (e.g., 1 + 65 = 66 => (char)66 = 'B')
                    break;
                case 2:
                    key.append((rand.nextInt(10)));
                    // 0 ~ 9
                    break;
            }
        }

        return key.toString();
    }

    public void SendAuthEmail(String toEmail) throws MessagingException {
        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");

        String authCode = createAuthCode();

        mailHelper.setFrom(emailFrom);
        mailHelper.setTo(toEmail);
        mailHelper.setText(authCode,true);
        mailHelper.setSubject("MingleCRM 회원가입 인증 이메일입니다!");

        mailSender.send(mail);

        redisDao.setValues(authCode, toEmail, Duration.ofMillis(60 * 5000L));
        System.out.println("Mail Sent Successfully!....");
        System.out.println(redisDao.getValues(authCode));
    }

    public Boolean AuthEmailCheck(String authCode, String toEmail) {

        String authEmail = redisDao.getValues(authCode);

        if (authEmail == null || !authEmail.equals(toEmail)) {
            return false;
        }
        redisDao.deleteValues(authEmail);
        return true;
    }
}
