package org.gcs.cja.repository;

import java.util.UUID;

import org.gcs.cja.entity.ScanBird;
import org.springframework.data.repository.CrudRepository;

import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;

public interface ScanBirdRepository extends CrudRepository<ScanBird, UUID> {
	
//	PreparedStatement result = session.execute("select birdlocation,birdspecies,birdtraits,scandate from birds where"
//			+ "birdid = ? and birdlocation=? and scandate=?;");
//	
//	BoundStatement boudStatement = new BoundStatement(statement);
//	ResultSet results = session.execute(boundStatement.bind(birdlocation, scandate));

}
