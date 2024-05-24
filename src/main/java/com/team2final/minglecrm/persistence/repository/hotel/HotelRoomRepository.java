package com.team2final.minglecrm.persistence.repository.hotel;

import com.team2final.minglecrm.entity.hotel.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoom, Long> {
}
