package com.example.mersbens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import database.Car;
import database.DatabaseHelper;

public class MenuCarsActivity extends AppCompatActivity {

	RelativeLayout recyclerViewSportCars, recyclerViewSuvsCars, recyclerViewElectricCars;
	String category = "", title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_cars);
		Toolbar toolbar = findViewById(R.id.toolBar);
		setSupportActionBar(toolbar);

		DatabaseHelper db = new DatabaseHelper(getApplicationContext());
		Log.d("sizeDB", "sizeDB " + db.getCountCars());
		if (db.getCountCars() == 0) {
			ArrayList<Car> cars = getListCars();
			for (Car car: cars) {
				db.addCar(car);
			}
		}

		recyclerViewSportCars = findViewById(R.id.relativeLayoutSportCar);
		recyclerViewSuvsCars = findViewById(R.id.relativeLayoutSuvsCars);
		recyclerViewElectricCars = findViewById(R.id.relativeLayoutElectricCars);

		recyclerViewSportCars.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				category = "sport";
				title = "Sports Cars";
				createNewActivity();
			}
		});

		recyclerViewSuvsCars.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				category = "suvs";
				title = "SUVs Cars";
				createNewActivity();
			}
		});

		recyclerViewElectricCars.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(MenuCarsActivity.this, "У розробці", Toast.LENGTH_LONG).show();
				category = "electric";
			}
		});

	}

	public void createNewActivity() {
		Intent intent = new Intent(getApplicationContext(), CategoryCarsActivity.class);
		intent.putExtra("category", this.category);
		intent.putExtra("title", title);
		startActivity(intent);
	}

	public ArrayList<Car> getListCars() {

		ArrayList<Car> cars = new ArrayList<>();
		cars.add(new Car(R.drawable.merc_amg_gt, R.drawable.merc_amg_gt_2  ,R.raw.merc_amg_gt, "Mercedes-AMG GT", "Mercedes-AMG GT - це спортивний автомобіль, який вперше був представлений у " +
			"2014 році. Його виробляє німецький автовиробник Mercedes-Benz. Автомобіль доступний " +
			"у двох варіантах кузова: купе та кабріолет.", "2014",
			"Німеччина", "2 двері і 4 місця", "310 км/год",
			"Автоматична ", "Повний", "Бензин", "66 літрів",
			"1 084 834$", "sport"));
		cars.add(new Car(R.drawable.merc_amg_c_63, R.drawable.merc_amg_c_63_2, R.raw.merc_amg_c_63,
			"Mercedes-AMG C63", "Mercedes-AMG C 63 - це спортивний седан, який вперше був представлений у 2015 році. Його виробляє німецький автовиробник Mercedes-Benz. Автомобіль доступний у двох варіантах кузова: седан і купе.",
			"2015", "Німеччина", "4 двері, 5 місць", "290 км/год", "Автоматична", "задній або повний",
			"Бензин", "66 літрів", "1 024 834$", "sport"));
		cars.add(new Car(R.drawable.merc_gle,R.drawable.merc_gle_2, R.raw.merc_gle, "Mercedes-Benz GLE",
			"Mercedes-Benz GLE-Class представляє собою розкішний і витончений SUV, який поєднує в собі комфорт та високу прохідність. Він оснащений передовими технологіями та елегантним дизайном, що робить його привабливим для тих, хто цінує стиль і функціональність.",
			"2019", "Німеччина", "4 двері, 7 місць", " 200 км/год", "Автоматична", "Повний", " Бензин або дизель", "75",
			"70 000$", "suvs"));
		cars.add(new Car(R.drawable.merc_glb, R.drawable.merc_glb_2, R.raw.merc_glb, "Mercedes-Benz GLB",
			"Mercedes-Benz GLB-Class - це компактний SUV, який поєднує в собі стильний дизайн і просторий кабінний простір. Він вражає функціональністю та високотехнологічним обладнанням.",
			"2019", "Німеччина", "4 двері, 7 місць", "200 км/год", "Автоматична", "Передній або повний",
			"Бензин", "50-60 літрів", "40 000$", "suvs"));
		return cars;
	}
}

/*
* new Car(R.drawable.merc_amg_gt, R.raw.merc_amg_gt, "Mercedes-AMG GT", "Опис: Mercedes-AMG GT - це спортивний автомобіль, який вперше був представлений у " +
			"2014 році. Його виробляє німецький автовиробник Mercedes-Benz. Автомобіль доступний " +
			"у двох варіантах кузова: купе та кабріолет.", "2014",
			"Німеччина", "2 двері і 4 місця", "310 км/год",
			"Автоматична ", "Повний", "Бензин", "66 літрів",
			"1 084 834$", "sport")

		Car car = new Car(R.drawable.merc_amg_c_63, R.raw.merc_amg_c_63,
			"Mercedes-AMG C63", "Mercedes-AMG C 63 - це спортивний седан, який вперше був представлений у 2015 році. Його виробляє німецький автовиробник Mercedes-Benz. Автомобіль доступний у двох варіантах кузова: седан і купе.",
			"2015", "Німеччина", "4 двері, 5 місць", "290 км/год", "Автоматична", "задній або повний",
			"Бензин", "66 літрів", "1 024 834$", "sport");
		Car car2 = new Car(
			R.drawable.merc_gle, R.raw.merc_gle, "Mercedes-Benz GLE",
			"Mercedes-Benz GLE-Class представляє собою розкішний і витончений SUV, який поєднує в собі комфорт та високу прохідність. Він оснащений передовими технологіями та елегантним дизайном, що робить його привабливим для тих, хто цінує стиль і функціональність.",
			"2019", "Німеччина", "4 двері, 7 місць", " 200 км/год", "Автоматична", "Повний", " Бензин або дизель", "75",
			"70 000$", "suvs");
		Car car3 = new Car(
			R.drawable.merc_glb, R.raw.merc_glb, "Mercedes-Benz GLB",
			"Mercedes-Benz GLB-Class - це компактний SUV, який поєднує в собі стильний дизайн і просторий кабінний простір. Він вражає функціональністю та високотехнологічним обладнанням.",
			"2019", "Німеччина", "4 двері, 7 місць", "200 км/год", "Автоматична", "Передній або повний",
			"Бензин", "50-60 літрів", "40 000$", "suvs"
			);
*
*  */