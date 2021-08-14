package com.movie.booking.api.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.movie.booking.api.model.MovieModel;
import com.movie.booking.api.model.ReservationModel;
import com.movie.booking.api.model.ReservationPostModel;
import com.movie.booking.api.service.EmailService;
import com.movie.booking.api.service.ReservationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/reservations")
@AllArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final EmailService emailService;
    private final ModelMapper modelMapper;

    //Request POST : /api/reservations
    //This method is called after the payment and send the e-ticket by email in QRCode format
    @PostMapping
    public ReservationModel addReservation(@RequestBody ReservationPostModel reservationPostModel) throws WriterException, IOException {
        String message = "<p>Bonjour "+ reservationPostModel.getFirstName() + " " + reservationPostModel.getLastName()+",</p>" +
                "<p>Voici votre e-ticket pour votre séance du : " + reservationPostModel.getScreening().getScreeningDate().toString() + "</p>";
        message += "<p>Noubliez pas de presenter le ticket le jour de votre visite. Bon vissionement!</p>";
        String content = "Date: " + reservationPostModel.getScreening().getScreeningDate() + "\n";
        content += "Film: " + reservationPostModel.getScreening().getMovie() + "\n";
        content += "Salle: " + reservationPostModel.getScreening().getAuditorium().getName() + "\n";
        content += "Places: " + reservationPostModel.getTotalSeats();
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
                barcodeWriter.encode(content, BarcodeFormat.QR_CODE, 200, 200);
        BufferedImage qrcode =  MatrixToImageWriter.toBufferedImage(bitMatrix);
        emailService.sendReservation("moviebooking@test.com", reservationPostModel.getEmail(),"Movie Booking - Reservation (e-ticket)", message, qrcode);
        return null;
    }
}
