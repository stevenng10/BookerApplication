package com.booker.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.booker.app.model.Reservation;
import com.booker.app.model.ServiceClass;
import com.booker.app.repository.ReservationRepository;

public class ReservationService {

	private ReservationRepository reservationRepository;
	private ServiceService serviceService;
	private CustomerService customerService;

	public ReservationService(ReservationRepository reservationRepository, ServiceService serviceService) {
		super();
		this.reservationRepository = reservationRepository;
		this.serviceService = serviceService;
	}

	@Autowired
	public void setCustomerService(@Qualifier("cs") CustomerService customerService) {
		this.customerService = customerService;
	}

	public Reservation findById(int id) {
		return reservationRepository.findById(id).get();
	}

	public List<Reservation> findAll() {
		return (List<Reservation>) reservationRepository.findAll();
	}

	@Transactional
	public List<Reservation> saveAllReservation(List<Reservation> reservations) {
		for (Reservation reservation : reservations) {
			for (ServiceClass service : reservation.getAvailedServiceList()) {
				if (!serviceService.doExist(service.getServiceId())) {
					throw new RuntimeException("Error! Service Id does not exist!");
				}
			}

			if (!customerService.doExist(reservation.getCustomer().getCustomerId())) {
				throw new RuntimeException("Error! Customer Id does not exist!");
			}
		}

		return (List<Reservation>) reservationRepository.saveAll(reservations);
	}

	@Transactional
	public Reservation saveReservation(Reservation reservation) {
		for (ServiceClass service : reservation.getAvailedServiceList()) {
			if (!serviceService.doExist(service.getServiceId())) {
				throw new RuntimeException("Error! Service Id does not exist!");
			}
		}
		if (!customerService.doExist(reservation.getCustomer().getCustomerId())) {
			throw new RuntimeException("Error! Customer Id does not exist!");
		}
		return reservationRepository.save(reservation);
	}

	public void deleteReservation(Reservation reservation) {
		reservationRepository.delete(reservation);
	}

	public void deleteAllReservation(List<Integer> ids) {
		reservationRepository.deleteAll(reservationRepository.findAllById(ids));
	}
}
