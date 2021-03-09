package in.edac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.edac.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

	Patient findByUsernameAndPassword(String username, String password);
}
