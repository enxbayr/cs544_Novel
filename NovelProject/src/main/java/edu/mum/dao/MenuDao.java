package edu.mum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.mum.domain.*;


//TODO Chingun - Dao
@Repository
public interface MenuDao extends JpaRepository<Menu, Long> {

	Menu getById(long menuId);

	
}
