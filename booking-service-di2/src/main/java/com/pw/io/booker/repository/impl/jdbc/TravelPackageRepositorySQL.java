package com.pw.io.booker.repository.impl.jdbc;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pw.io.booker.model.TravelPackage;
import com.pw.io.booker.repository.TravelPackageRepository;

@Repository
@Primary
public interface TravelPackageRepositorySQL extends CrudRepository<TravelPackage, Integer>, TravelPackageRepository {

	public List<TravelPackage> findByDescription(String description);

	// below should work if its class instead of interface and implements
	// TravelPackageRepository
	/*
	 * private DataSource dataSource; private JdbcTemplate jdbcTemplate;
	 * 
	 * public TravelPackageRepositorySQL(DataSource dataSource, JdbcTemplate
	 * jdbcTemplate) { super(); this.dataSource = dataSource; this.jdbcTemplate =
	 * jdbcTemplate; }
	 */

	/*
	 * private EntityManager entityManager;
	 * 
	 * public TravelPackageRepositorySQL(EntityManager entityManager) { super();
	 * this.entityManager = entityManager; }
	 * 
	 * @Override public List<TravelPackage> findAll() { // return
	 * jdbcTemplate.query("select * from travel_package", new //
	 * TravelPackageRowMapper()); return
	 * entityManager.createQuery("from TravelPackage").getResultList(); }
	 */

	/*
	 * @Override public TravelPackage findById(int id) { // return
	 * jdbcTemplate.queryForObject("select * from travel_package where //
	 * travel_package_id = ?", // new TravelPackageRowMapper(), id); return
	 * entityManager.find(TravelPackage.class, id); }
	 * 
	 * @Transactional
	 * 
	 * @Override public TravelPackage save(TravelPackage model) {
	 * 
	 * jdbcTemplate.update("insert into travel_package values (?, ?, ?)",
	 * model.getTravelPackageId(), model.getDescription(), model.getPackageName());
	 * 
	 * entityManager.persist(model); return model; }
	 * 
	 * @Transactional
	 * 
	 * @Override public void delete(TravelPackage model) { //
	 * jdbcTemplate.update("delete from travel_package where travel_package_id = ?",
	 * // model.getTravelPackageId()); entityManager.remove(model); }
	 */

}