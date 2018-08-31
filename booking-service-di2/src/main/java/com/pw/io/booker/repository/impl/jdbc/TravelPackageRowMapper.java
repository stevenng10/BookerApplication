package com.pw.io.booker.repository.impl.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pw.io.booker.model.TravelPackage;

public class TravelPackageRowMapper implements RowMapper<TravelPackage> {

	@Override
	public TravelPackage mapRow(ResultSet rs, int rowNum) throws SQLException {
		TravelPackage travelPackage = new TravelPackage();
		travelPackage.setTravelPackageId(rs.getInt("travel_package_id"));
		travelPackage.setPackageName(rs.getString("package_name"));
		travelPackage.setDescription(rs.getString("description"));
		return travelPackage;
	}

}
