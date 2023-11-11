package database;

import com.example.mersbens.R;

import java.util.ArrayList;

public class MercedesBenz {
	private ArrayList<Car> cars;
	private Car mercedesAmgGt;
	public MercedesBenz(){
		this.cars = new ArrayList<>();
		initCars();
	}

	private void initCars() {
		mercedesAmgGt = new Car(R.drawable.merc_amg_gt, R.drawable.merc_amg_gt_2  ,R.raw.merc_amg_gt,
			"Mercedes-AMG GT", "Mercedes-AMG GT - це спортивний автомобіль, який вперше був представлений у " +
			"2014 році. Його виробляє німецький автовиробник Mercedes-Benz. Автомобіль доступний " +
			"у двох варіантах кузова: купе та кабріолет.", "2014",
			"Німеччина", "2 двері і 4 місця", "310 км/год",
			"Автоматична ", "Повний", "Бензин", "66 літрів",
			"1 084 834$", "sport");

		cars.add(mercedesAmgGt);
	}

	public ArrayList<Car> getArrayList() {
		return this.cars;
	}
}
