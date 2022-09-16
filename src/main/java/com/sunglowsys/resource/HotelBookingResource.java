package com.sunglowsys.resource;

import com.sunglowsys.domain.HotelBooking;
import com.sunglowsys.service.HotelBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HotelBookingResource {
    private final Logger logger = LoggerFactory.getLogger(HotelBookingResource.class);
    private final HotelBookingService hotelBookingService;

    public HotelBookingResource(HotelBookingService hotelBookingService) {
        this.hotelBookingService = hotelBookingService;
    }
    @PostMapping("/hotelBookings")
    public ResponseEntity<HotelBooking> createHotelBooking(@RequestBody HotelBooking hotelBooking) {
        logger.debug("request to create hoteBooking:{}",hotelBooking);
        HotelBooking result = hotelBookingService.save(hotelBooking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping("/hotelBookings")
    public ResponseEntity<HotelBooking> updateHotelBooking(@RequestBody HotelBooking hotelBooking) {
        logger.debug("request to update hotelBooking:{}",hotelBooking);
        if (hotelBooking.getId()==null) {
            throw new RuntimeException("it not be must null");
        }
        HotelBooking result = hotelBookingService.update(hotelBooking);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/hotelBookings")
    public ResponseEntity<Page<HotelBooking>> findAllHotelBooking(Pageable pageable) {
        logger.debug("request to findAll hotelBooking:{}",pageable);
        Page<HotelBooking> result = hotelBookingService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/hotelBookings/{id}")
    public ResponseEntity<Optional<HotelBooking>> findOneHotelBooking(@PathVariable Long id) {
        logger.debug("request to findOne hotelBooking:{}",id);
        Optional<HotelBooking> result = hotelBookingService.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @DeleteMapping("/hotelBookings/{id}")
    public ResponseEntity<Void> deleteHotelBooking(@PathVariable Long id) {
        logger.debug("request to delete hotalBooking:{}",id);
        hotelBookingService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
