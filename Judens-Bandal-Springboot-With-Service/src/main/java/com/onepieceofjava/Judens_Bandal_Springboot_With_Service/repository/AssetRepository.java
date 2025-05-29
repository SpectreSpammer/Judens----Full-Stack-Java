package com.onepieceofjava.Judens_Bandal_Springboot_With_Service.repository;


import com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model.Assets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Assets,Long> {
}
