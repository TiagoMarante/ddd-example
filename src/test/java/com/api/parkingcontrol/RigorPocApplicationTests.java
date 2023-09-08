package com.api.parkingcontrol;

import com.api.parkingcontrol.models.VehicleStockEntry.VehicleStockEntry;
import com.api.parkingcontrol.repository.VehicleStockEntryRepository;
import com.api.parkingcontrol.service.VehicleStockEntryService;
import org.hibernate.validator.internal.util.Contracts;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@SpringBootTest
class RigorPocApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	private VehicleStockEntryService vehicleStockEntryService;

	@MockBean
	private VehicleStockEntryRepository vehicleStockEntryRepository;

	@Test
	public void testSomeServiceMethod() {
		// Arrange
		VehicleStockEntry entity = new VehicleStockEntry();
		entity.setId(1L);
		Mockito.when(vehicleStockEntryRepository.findById(1L)).thenReturn(Optional.of(entity));

		// Act
		var result = vehicleStockEntryService.findById(1L);

		System.out.println(result);

		// Assert
		assertNotNull(result);
		Contracts.assertTrue(1L == result.getId(), "If they have the same id");
	}


}
