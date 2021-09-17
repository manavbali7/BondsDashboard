package bondsDashboard.model;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import bondsDashboard.model.Bond;

public interface BondRepository extends CrudRepository<Bond, Integer> {
	Bond findById(int id);
	List<Bond> findBySold(Boolean sold);

}
