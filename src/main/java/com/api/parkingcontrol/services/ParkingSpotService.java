package com.api.parkingcontrol.services;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotService {

  // @Autowired - Pode ser utilizado em vez de injeção via contrutor.
  final ParkingSpotRepository parkingSpotRepository;

  public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
    this.parkingSpotRepository = parkingSpotRepository;
  }

  public Page<ParkingSpotModel> getAll(Pageable pageable) {
    return parkingSpotRepository.findAll(pageable);
  }

  public Optional<ParkingSpotModel> getById(UUID id) {
    return parkingSpotRepository.findById(id);
  }

  @Transactional // Caso algo dê errado ao salvar, é feito o rollback.
  public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
    return parkingSpotRepository.save(parkingSpotModel);
  }

  public boolean existsByLicensePlateCar(String licensePlateCar) {
    return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
  }

  public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
    return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
  }

  public boolean existsByApartmentAndBlock(String apartment, String block) {
    return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
  }

  @Transactional // Caso algo dê errado ao salvar, é feito o rollback.
  public void delete(ParkingSpotModel parkingSpot) {
    parkingSpotRepository.delete(parkingSpot);
  }

}
