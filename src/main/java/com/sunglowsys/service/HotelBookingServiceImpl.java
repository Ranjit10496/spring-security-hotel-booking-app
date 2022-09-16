package com.sunglowsys.service;

import com.sunglowsys.domain.HotelBooking;
import com.sunglowsys.repository.HotelBookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional

public class HotelBookingServiceImpl implements HotelBookingService {
    private final Logger logger = LoggerFactory.getLogger(HotelBookingRepository.class);
    private final HotelBookingRepository hotelBookingRepository;

    public HotelBookingServiceImpl(HotelBookingRepository hotelBookingRepository) {
        this.hotelBookingRepository = hotelBookingRepository;
    }

    @Override
    public HotelBooking save(HotelBooking hotelBooking) {
        logger.debug("request to save hotelBooking:{}",hotelBooking);
        return hotelBookingRepository.save(hotelBooking);
    }

    @Override
    public HotelBooking update(HotelBooking hotelBooking) {
        logger.debug("request to update hotelbooking:{}",hotelBooking);
        return hotelBookingRepository.save(hotelBooking);
    }

    @Override
    public Page<HotelBooking> findAll(Pageable pageable) {
        logger.debug("request to findAll hotelBooking:{}",pageable);
        return hotelBookingRepository.findAll(pageable);
    }

    @Override
    public Optional<HotelBooking> findOne(Long id) {
        logger.debug("request to findOne hotelBooking:{}",id);
        return hotelBookingRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        logger.debug("request to delete hotelBooking:{}",id);
        hotelBookingRepository.deleteById(id);

    }
}
