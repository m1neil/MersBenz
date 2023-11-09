package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
	public DatabaseHelper(Context context) {
		super(context, Utils.DATABASE_NAME, null, Utils.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String createTable = "CREATE TABLE " + Utils.TABLE_NAME_CARS + "("
			+ Utils.KEY_ID + " INTEGER PRIMARY KEY,"
			+ Utils.KEY_IMAGE_PATH + " INTEGER,"
			+ Utils.KEY_VIDEO_PATH + " INTEGER,"
			+ Utils.KEY_MODEL + " TEXT,"
			+ Utils.KEY_DESCRIPTION + " TEXT,"
			+ Utils.KEY_YEAR_PRODUCED + " TEXT,"
			+ Utils.KEY_COUNTRY_PRODUCED + " TEXT,"
			+ Utils.KEY_DOORS_AND_PLACES + " TEXT,"
			+ Utils.KEY_MAX_SPEED + " TEXT,"
			+ Utils.KEY_TYPE_TRANSMISSION + " TEXT,"
			+ Utils.KEY_DRIVE_UNIT + " TEXT,"
			+ Utils.KEY_FUEL_TYPE + " TEXT,"
			+ Utils.KEY_FUEL_TANK_CAPACITY + " TEXT,"
			+ Utils.KEY_MIDDLE_PRICE + " TEXT,"
			+ Utils.KEY_CATEGORY + " TEXT" +
			")";

		db.execSQL(createTable);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + Utils.TABLE_NAME_CARS);
		onCreate(db);
	}

	public void addCar(Car car) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues contentValues = new ContentValues();
		contentValues.put(Utils.KEY_IMAGE_PATH, car.getImagePath());
		contentValues.put(Utils.KEY_VIDEO_PATH, car.getVideoPath());
		contentValues.put(Utils.KEY_MODEL, car.getModel());
		contentValues.put(Utils.KEY_DESCRIPTION, car.getDescription());
		contentValues.put(Utils.KEY_YEAR_PRODUCED, car.getYearProduced());
		contentValues.put(Utils.KEY_COUNTRY_PRODUCED, car.getCountryProduced());
		contentValues.put(Utils.KEY_DOORS_AND_PLACES, car.getCountDoorsAndPlaces());
		contentValues.put(Utils.KEY_MAX_SPEED, car.getMaxSpeed());
		contentValues.put(Utils.KEY_TYPE_TRANSMISSION, car.getTypeTransmission());
		contentValues.put(Utils.KEY_DRIVE_UNIT, car.getDriveUnit());
		contentValues.put(Utils.KEY_FUEL_TYPE, car.getFuelType());
		contentValues.put(Utils.KEY_FUEL_TANK_CAPACITY, car.getFuelTankCapacity());
		contentValues.put(Utils.KEY_MIDDLE_PRICE, car.getMiddlePrice());
		contentValues.put(Utils.KEY_CATEGORY, car.getCategory());

		db.insert(Utils.TABLE_NAME_CARS, null, contentValues);
		db.close();
	}

	public List<Car> getCarByCategory(String category) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(Utils.TABLE_NAME_CARS,
			new String[]{Utils.KEY_ID, Utils.KEY_MODEL, Utils.KEY_TYPE_TRANSMISSION, Utils.KEY_IMAGE_PATH, Utils.KEY_DRIVE_UNIT,
				Utils.KEY_DOORS_AND_PLACES, Utils.KEY_MAX_SPEED, Utils.KEY_FUEL_TANK_CAPACITY},
			Utils.KEY_CATEGORY + "=?",
			new String[]{category},
			null, null, null, null);

		List<Car> cars = new ArrayList<>();

		int id = cursor.getColumnIndex(Utils.KEY_ID);
		int idModel = cursor.getColumnIndex(Utils.KEY_MODEL);
		int idImagePath = cursor.getColumnIndex(Utils.KEY_IMAGE_PATH);
		int idDriveUnit = cursor.getColumnIndex(Utils.KEY_DRIVE_UNIT);
		int idCountDoors = cursor.getColumnIndex(Utils.KEY_DOORS_AND_PLACES);
		int idMaxSpeed = cursor.getColumnIndex(Utils.KEY_MAX_SPEED);
		int idTankCapacity = cursor.getColumnIndex(Utils.KEY_FUEL_TANK_CAPACITY);
		int idTransmission = cursor.getColumnIndex(Utils.KEY_TYPE_TRANSMISSION);

		if (cursor.moveToFirst()) {
			try {
				do {
					Car car = new Car();
					car.setId(cursor.getInt(id));
					car.setModel(cursor.getString(idModel));
					car.setImagePath(cursor.getInt(idImagePath));
					car.setDriveUnit(cursor.getString(idDriveUnit));
					car.setCountDoorsAndPlaces(cursor.getString(idCountDoors));
					car.setMaxSpeed(cursor.getString(idMaxSpeed));
					car.setFuelTankCapacity(cursor.getString(idTankCapacity));
					car.setTypeTransmission(cursor.getString(idTransmission));
					cars.add(car);
				} while (cursor.moveToNext());
			} finally {
				cursor.close();
			}
		}

		return cars;
	}

	public int getCountCars() {
		SQLiteDatabase db = this.getReadableDatabase();
		String query = "SELECT * FROM " + Utils.TABLE_NAME_CARS;

		Cursor cursor = db.rawQuery(query, null);
		int count = -1;

		if (cursor != null) {
			try {
				count = cursor.getCount();
			} finally {
				cursor.close();
			}
		}
		return count;
	}

}
