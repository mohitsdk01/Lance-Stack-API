package com.lancestack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lancestack.entities.Contract;
import com.lancestack.entities.ContractStatus;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

	@Query("SELECT c FROM Contract c WHERE c.status = 'IN_PROGRESS'")
    List<Contract> findAllContractsInProgress();
	
	List<Contract> findByStatus(ContractStatus status);
	
	List<Contract> findByFreelancerIdAndStatus(Long freelancerId, ContractStatus status);
	
	@Query(value = "SELECT * FROM contracts  WHERE status = 'IN_PROGRESS' AND freelancer_id = :freelancerId", nativeQuery = true)
    List<Contract> findAllContractsInProgressByFreelancerId(Long freelancerId);

	@Query(value = "SELECT * FROM contracts  WHERE status = 'COMPLETED' AND freelancer_id = :freelancerId", nativeQuery = true)
    List<Contract> findAllContractsCompletedByFreelancerId(Long freelancerId);
}
