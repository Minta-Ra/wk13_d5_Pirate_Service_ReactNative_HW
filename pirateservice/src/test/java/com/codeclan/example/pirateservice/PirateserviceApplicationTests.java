package com.codeclan.example.pirateservice;

import com.codeclan.example.pirateservice.models.Pirate;
import com.codeclan.example.pirateservice.models.Raid;
import com.codeclan.example.pirateservice.models.Ship;
import com.codeclan.example.pirateservice.repositories.PirateRepository;
import com.codeclan.example.pirateservice.repositories.RaidRepository;
import com.codeclan.example.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void createPirate(){
//		Ship ship = new Ship("The Flying Dutchman");
//		shipRepository.save(ship);
//
//		Pirate jack = new Pirate("Jack", "Sparrow", 32, ship);
//		pirateRepository.save(jack);
//
//		Raid raid1 = new Raid("Tortuga", 100);
//		raidRepository.save(raid1);
//
//		raid1.addPirate(jack);
//		raidRepository.save(raid1);
//	}

	@Test
	public void canFindPiratesOver30(){
		List<Pirate> found = pirateRepository.findByAgeGreaterThan(30);
		assertEquals(7, found.size());
	}

	@Test
	public void findRaidByLocation(){
		List<Raid> found = raidRepository.findRaidByLocation("Tortuga");
		assertEquals("Tortuga", found.get(0).getLocation());
	}

	@Test
	public void findPiratesByRaidId(){
		List<Pirate> foundPirates = pirateRepository.findByRaidsId(1L);
		assertEquals(1, foundPirates.size());
		assertEquals("Jack", foundPirates.get(0).getFirstName());
	}

	@Test
	public void canFindShipForPiratesFirstName(){
		List<Ship> foundShips = shipRepository.findByPiratesFirstName("Maggie");
		assertEquals(1, foundShips.size());
	}

	@Test
	public void canFindALlRaidsForAGivenShip(){
		Ship foundShip = shipRepository.getById(3L);
		List<Raid> foundRaids = raidRepository.findByPiratesShip(foundShip);
		assertEquals(2, foundRaids.size());
	}

}
