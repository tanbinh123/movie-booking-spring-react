package com.movie.booking.api.service;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.apache.commons.codec.binary.Base64OutputStream;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.util.Base64;

@Component
@AllArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;

    public void sendReservation(String from, String to, String subject, String msg, BufferedImage qrcode) throws IOException {
        msg += "<img height=\"250\" width=\"250\" src=\"data:image/png;base64, " + imgToBase64String(qrcode) + "\"/>";
        try {
            MimeMessage message = emailSender.createMimeMessage();
            message.setSubject(subject);
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setText(msg, true);
            emailSender.send(message);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static String imgToBase64String(final BufferedImage bufferedImage) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        OutputStream b64 = new Base64OutputStream(os);
        ImageIO.write(bufferedImage, "png", b64);
        String result = os.toString("UTF-8");
        return result;
    }
}
