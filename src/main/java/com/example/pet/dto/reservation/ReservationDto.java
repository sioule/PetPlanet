package com.example.pet.dto.reservation;

import com.example.pet.domain.reservation.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {


    private int revId;
    private int memberId;
    private int placeId;
    private String placeName;
    private String revName;
    private String phoneNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate visitDate;
    private String time;
    private int guests;
    private int status;


    //dto -> entity
    public Reservation toEntity() {

        return Reservation.builder()
                .Id(revId)
                .revName(revName)
                .phoneNum(phoneNum)
                .visitDate(visitDate)
                .time(time)
                .guests(guests)
                .build();
    }

}

