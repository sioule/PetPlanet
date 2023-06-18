package com.example.pet.controller;

import com.example.pet.domain.place.Place;
import com.example.pet.dto.reservation.ReservationDto;
import com.example.pet.dto.reservation.ReservationListDto;
import com.example.pet.repository.PlaceRepository;
import com.example.pet.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ReservationController {

    private final ReservationService reservationService;
    private final PlaceRepository placeRepository;


       /*
      예약 작성 폼 placeType==hetel -> reservation-FormB.jsp로 이동
        */
    @GetMapping("/reservation/{memberId]")
    public String reservationFormA(@PathVariable int memberId, @RequestParam int placeId, Model model){

        model.addAttribute("memberId", memberId);
        model.addAttribute("placeId", placeId);

        Optional<Place> place = placeRepository.findById(placeId);
        String placeType = place.get().getPlaceType();

        if("hotel".equals(placeType))
            return "reservation-FormB";

        return "reservation-FormA";
    }



        /*
    예약 정보 입력 (카페, 운동장, 식당 전용)
    (type=Unsupported Media Type, status=415) 에러 -> @ModelAttribute 사용
     */

    @PostMapping("/reservation/{memberId]/confirm/a")
    public String checkReservationFormA(@PathVariable int memberId, @ModelAttribute("rev") ReservationDto reservationDto, Model model){

        model.addAttribute("memberId", memberId);
        reservationService.checkFormA(reservationDto);

        return "reservation-ConfirmA";

    }



    /*
    예약 정보 입력 (숙소 전용)
    (type=Unsupported Media Type, status=415) 에러 -> @ModelAttribute 사용
     */

    @PostMapping("/reservation/confirm/b")
    public String checkReservationFormB(@PathVariable int memberId, @ModelAttribute("rev") ReservationDto reservationDto){

        reservationService.checkFormB(reservationDto);

        return "reservation-ConfirmB";

    }



    /*
     예약하기 API
  */
    @PostMapping("/reservation/{memberId}")
    public String saveReservationA(@PathVariable int memberId, @ModelAttribute("rev") ReservationDto reservationDto){

        reservationService.saveReservation(memberId, reservationDto);

        //추후 수정: 예약 성공시 나의 예약 페이지로 리다이렉트
        return"reservation-success";


    }



    /*
    내가 쓴 예약 조회 API
     */

    @GetMapping("/myPage/{memberId}/reservations")
    public List<ReservationListDto> getReview(@PathVariable int memberId){

        return reservationService.getMyReservation(memberId);

    }


}
