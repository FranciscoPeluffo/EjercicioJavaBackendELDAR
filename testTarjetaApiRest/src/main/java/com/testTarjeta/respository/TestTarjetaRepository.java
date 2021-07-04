package com.testTarjeta.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testTarjeta.entity.Role;


@Repository
public interface TestTarjetaRepository extends CrudRepository<Role, Long>{
	 
}
