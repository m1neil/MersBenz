package database;

import com.example.mersbens.R;

import java.util.ArrayList;

public class MercedesBenz {
	private ArrayList<Car> cars;
	private Car mercedesAmgGt;

	public MercedesBenz() {
		this.cars = new ArrayList<>();
		initCars();
	}

	private void initCars() {
		cars.add(new Car(
			UtilTexts.MERC_1_IMAGE_1, UtilTexts.MERC_1_IMAGE_2, UtilTexts.MERC_1_VIDEO,
			UtilTexts.MERC_1_MODEL, UtilTexts.MERC_1_DESCRIPTION, UtilTexts.MERC_1_YEAR,
			UtilTexts.MERC_1_COUNTRY, UtilTexts.MERC_1_DOORS_PLACES, UtilTexts.MERC_1_MAX_SPEED,
			UtilTexts.MERC_1_TYPE_TRANSMISSION, UtilTexts.MERC_1_DRIVE_UNIT,
			UtilTexts.MERC_1_FUEL_TYPE, UtilTexts.MERC_1_FUEL_TANK_CAPACITY,
			UtilTexts.MERC_1_MIDDLE_PRICE, UtilTexts.MERC_1_CATEGORY, UtilTexts.MERC_1_ENGINE,
			UtilTexts.MERC_1_ENGINE_DESCR, UtilTexts.MERC_1_SUSPENSION_DESCR,
			UtilTexts.MERC_1_TRANSMISSION_DESCR, UtilTexts.MERC_1_BRAKE_SYSTEM_DESCR,
			UtilTexts.MERC_1_WHEELS_TIRES_DESCR, UtilTexts.MERC_1_ELECTRICAL_EQUIPMENT));
		cars.add(new Car(
			UtilTexts.MERC_2_IMAGE_1,
			UtilTexts.MERC_2_IMAGE_2,
			UtilTexts.MERC_2_VIDEO,
			UtilTexts.MERC_2_MODEL,
			UtilTexts.MERC_2_DESCRIPTION,
			UtilTexts.MERC_2_YEAR,
			UtilTexts.MERC_2_COUNTRY,
			UtilTexts.MERC_2_DOORS_PLACES,
			UtilTexts.MERC_2_MAX_SPEED,
			UtilTexts.MERC_2_TYPE_TRANSMISSION,
			UtilTexts.MERC_2_DRIVE_UNIT,
			UtilTexts.MERC_2_FUEL_TYPE,
			UtilTexts.MERC_2_FUEL_TANK_CAPACITY,
			UtilTexts.MERC_2_MIDDLE_PRICE,
			UtilTexts.MERC_2_CATEGORY,
			UtilTexts.MERC_2_ENGINE,
			UtilTexts.MERC_2_ENGINE_DESCR,
			UtilTexts.MERC_2_SUSPENSION_DESCR,
			UtilTexts.MERC_2_TRANSMISSION_DESCR,
			UtilTexts.MERC_2_BRAKE_SYSTEM_DESCR,
			UtilTexts.MERC_2_WHEELS_TIRES_DESCR,
			UtilTexts.MERC_2_ELECTRICAL_EQUIPMENT));
		cars.add(new Car(
			UtilTexts.MERC_3_IMAGE_1,
			UtilTexts.MERC_3_IMAGE_2,
			UtilTexts.MERC_3_VIDEO,
			UtilTexts.MERC_3_MODEL,
			UtilTexts.MERC_3_DESCRIPTION,
			UtilTexts.MERC_3_YEAR,
			UtilTexts.MERC_3_COUNTRY,
			UtilTexts.MERC_3_DOORS_PLACES,
			UtilTexts.MERC_3_MAX_SPEED,
			UtilTexts.MERC_3_TYPE_TRANSMISSION,
			UtilTexts.MERC_3_DRIVE_UNIT,
			UtilTexts.MERC_3_FUEL_TYPE,
			UtilTexts.MERC_3_FUEL_TANK_CAPACITY,
			UtilTexts.MERC_3_MIDDLE_PRICE,
			UtilTexts.MERC_3_CATEGORY,
			UtilTexts.MERC_3_ENGINE,
			UtilTexts.MERC_3_ENGINE_DESCR,
			UtilTexts.MERC_3_SUSPENSION_DESCR,
			UtilTexts.MERC_3_TRANSMISSION_DESCR,
			UtilTexts.MERC_3_BRAKE_SYSTEM_DESCR,
			UtilTexts.MERC_3_WHEELS_TIRES_DESCR,
			UtilTexts.MERC_3_ELECTRICAL_EQUIPMENT));
		cars.add(new Car(
			UtilTexts.MERC_4_IMAGE_1,
			UtilTexts.MERC_4_IMAGE_2,
			UtilTexts.MERC_4_VIDEO,
			UtilTexts.MERC_4_MODEL,
			UtilTexts.MERC_4_DESCRIPTION,
			UtilTexts.MERC_4_YEAR,
			UtilTexts.MERC_4_COUNTRY,
			UtilTexts.MERC_4_DOORS_PLACES,
			UtilTexts.MERC_4_MAX_SPEED,
			UtilTexts.MERC_4_TYPE_TRANSMISSION,
			UtilTexts.MERC_4_DRIVE_UNIT,
			UtilTexts.MERC_4_FUEL_TYPE,
			UtilTexts.MERC_4_FUEL_TANK_CAPACITY,
			UtilTexts.MERC_4_MIDDLE_PRICE,
			UtilTexts.MERC_4_CATEGORY,
			UtilTexts.MERC_4_ENGINE,
			UtilTexts.MERC_4_ENGINE_DESCR,
			UtilTexts.MERC_4_SUSPENSION_DESCR,
			UtilTexts.MERC_4_TRANSMISSION_DESCR,
			UtilTexts.MERC_4_BRAKE_SYSTEM_DESCR,
			UtilTexts.MERC_4_WHEELS_TIRES_DESCR,
			UtilTexts.MERC_4_ELECTRICAL_EQUIPMENT
		));
		cars.add(new Car(
			UtilTexts.MERC_5_IMAGE_1,
			UtilTexts.MERC_5_IMAGE_2,
			UtilTexts.MERC_5_VIDEO,
			UtilTexts.MERC_5_MODEL,
			UtilTexts.MERC_5_DESCRIPTION,
			UtilTexts.MERC_5_YEAR,
			UtilTexts.MERC_5_COUNTRY,
			UtilTexts.MERC_5_DOORS_PLACES,
			UtilTexts.MERC_5_MAX_SPEED,
			UtilTexts.MERC_5_TYPE_TRANSMISSION,
			UtilTexts.MERC_5_DRIVE_UNIT,
			UtilTexts.MERC_5_FUEL_TYPE,
			UtilTexts.MERC_5_FUEL_TANK_CAPACITY,
			UtilTexts.MERC_5_MIDDLE_PRICE,
			UtilTexts.MERC_5_CATEGORY,
			UtilTexts.MERC_5_ENGINE,
			UtilTexts.MERC_5_ENGINE_DESCR,
			UtilTexts.MERC_5_SUSPENSION_DESCR,
			UtilTexts.MERC_5_TRANSMISSION_DESCR,
			UtilTexts.MERC_5_BRAKE_SYSTEM_DESCR,
			UtilTexts.MERC_5_WHEELS_TIRES_DESCR,
			UtilTexts.MERC_5_ELECTRICAL_EQUIPMENT
		));
	}


	public ArrayList<Car> getArrayList() {
		return this.cars;
	}
}
