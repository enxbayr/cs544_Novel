package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Item;

@Repository
public interface ItemDao extends JpaRepository<Item, Long> {
	// Basetai ajillah funciig todorhoilj ugnu

}
