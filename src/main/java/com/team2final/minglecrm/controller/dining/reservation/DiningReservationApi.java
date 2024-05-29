package com.team2final.minglecrm.controller.dining.reservation;

import com.team2final.minglecrm.controller.dining.reservation.request.UpdateDiningReservationRequest;
import com.team2final.minglecrm.controller.dining.reservation.response.DiningReservationResponse;
import com.team2final.minglecrm.service.dining.reservation.DishReservationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers/{customerId}/dish/reservations")
public class DiningReservationApi {
    private final DishReservationService dishReservationService;

    // 다이닝(디시) 전체 예약 내역
    @GetMapping()
    public ResponseEntity<List<DiningReservationResponse>> getReservationsList(
            @PathVariable Long customerId) {
        List<DiningReservationResponse> responses = dishReservationService.findById(customerId);
        return ResponseEntity.ok(responses);
    }

    // 다이닝(디시) 상세 예약 내역
    @GetMapping("/{reservationId}")
    public ResponseEntity<DiningReservationResponse> getRoomReservation(
            @PathVariable Long customerId, @PathVariable Long reservationId) {
        DiningReservationResponse diningReservationResponse = dishReservationService.findReservationById(
                customerId, reservationId);

        return ResponseEntity.ok(diningReservationResponse);
    }

    // 다이닝(디시) 예약 수정
    @PatchMapping("/{reservationId}")
    public void updateRoomReservation(
            @PathVariable Long customerId,
            @PathVariable Long reservationId,
            @RequestBody UpdateDiningReservationRequest updateDiningReservationRequest) {

        dishReservationService.updateDiningReservation(customerId, reservationId,
                updateDiningReservationRequest);
    }

    // 다이닝(디시) 상세 예약 삭제
    @DeleteMapping("/{reservationId}")
    public void cancelRoomReservation(
            @PathVariable Long customerId,
            @PathVariable Long reservationId) {
        dishReservationService.cancelDiningReservation(customerId, reservationId);
    }


}