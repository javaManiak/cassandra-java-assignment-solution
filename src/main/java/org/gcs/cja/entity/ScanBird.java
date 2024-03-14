package org.gcs.cja.entity;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("birds")
public class ScanBird implements Serializable {

	private static final long serialVersionUID = 1L;
	@PrimaryKey
	private UUID birdId = UUID.randomUUID();
	private String birdLocation;
	private String scanDate;
	private String birdSpecies;
	private String birdTraits;

	public ScanBird() {
		this.birdId = UUID.randomUUID();
	}

	public UUID getBirdId() {
		return birdId;
	}

	public void setBirdId(UUID birdId) {
		this.birdId = birdId;
	}

	public String getBirdLocation() {
		return birdLocation;
	}

	public void setBirdLocation(String birdLocation) {
		this.birdLocation = birdLocation;
	}

	public String getScanDate() {
		return scanDate;
	}

	public void setScanDate(String scanDate) {
		this.scanDate = scanDate;
	}

	public String getBirdSpecies() {
		return birdSpecies;
	}

	public void setBirdSpecies(String birdSpecies) {
		this.birdSpecies = birdSpecies;
	}

	public String getBirdTraits() {
		return birdTraits;
	}

	public void setBirdTraits(String birdTraits) {
		this.birdTraits = birdTraits;
	}

}
