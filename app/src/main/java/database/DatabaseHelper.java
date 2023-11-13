package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import User.User;

public class DatabaseHelper extends SQLiteOpenHelper {
	public DatabaseHelper(Context context) {
		super(context, Utils.DATABASE_NAME, null, Utils.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String createTable = "CREATE TABLE " + Utils.TABLE_NAME_CARS + "("
			+ Utils.KEY_ID + " INTEGER PRIMARY KEY,"
			+ Utils.KEY_IMAGE_PATH + " INTEGER,"
			+ Utils.KEY_IMAGE_PATH_SECOND + " INTEGER,"
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
			+ Utils.KEY_CATEGORY + " TEXT,"
			+ Utils.KEY_ENGINE + " TEXT,"
			+ Utils.KEY_ENGINE_DESCR + " TEXT,"
			+ Utils.KEY_SUSPENSION_DESCR + " TEXT,"
			+ Utils.KEY_TRANSMISSION_DESCR + " TEXT,"
			+ Utils.KEY_BRAKE_SYSTEM_DESCR + " TEXT,"
			+ Utils.KEY_WHEELS_TIRES_DESCR + " TEXT,"
			+ Utils.KEY_ELECTRICAL_EQUIPMENT + " TEXT" +
			")";

		String createTableUsers = "CREATE TABLE " + UtilsUsers.TABLE_NAME + "("
			+ UtilsUsers.KEY_ID + " INTEGER PRIMARY KEY,"
			+ UtilsUsers.KEY_NAME + " TEXT,"
			+ UtilsUsers.KEY_EMAIL + " TEXT,"
			+ UtilsUsers.KEY_PASSWORD + " TEXT,"
			+ UtilsUsers.KEY_LIKE_CARS + " TEXT" + ")";

		db.execSQL(createTable);
		db.execSQL(createTableUsers);
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
		contentValues.put(Utils.KEY_IMAGE_PATH_SECOND, car.getImagePathSecond());
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
		contentValues.put(Utils.KEY_ENGINE, car.getEngine());
		contentValues.put(Utils.KEY_ENGINE_DESCR, car.getEngineDescr());
		contentValues.put(Utils.KEY_SUSPENSION_DESCR, car.getSuspensionDescr());
		contentValues.put(Utils.KEY_TRANSMISSION_DESCR, car.getTransmissionDescr());
		contentValues.put(Utils.KEY_BRAKE_SYSTEM_DESCR, car.getBrakeSystemDescr());
		contentValues.put(Utils.KEY_WHEELS_TIRES_DESCR, car.getWheelsTiresDescr());
		contentValues.put(Utils.KEY_ELECTRICAL_EQUIPMENT, car.getElectricalEquipment());

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

	public int getCarByName(String name) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(Utils.TABLE_NAME_CARS,
			new String[]{Utils.KEY_ID},
			Utils.KEY_MODEL + "=?",
			new String[]{name},
			null, null, null, null);

		int id = 0;

		if (cursor.moveToFirst()) {
			try {
				int idIndex = cursor.getColumnIndex(Utils.KEY_ID);
				id = cursor.getInt(idIndex);
			} finally {
				cursor.close();
			}
		}

		return id;
	}

	public Car getCarById(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(Utils.TABLE_NAME_CARS, new String[]{Utils.KEY_ID, Utils.KEY_MODEL,
				Utils.KEY_IMAGE_PATH_SECOND, Utils.KEY_VIDEO_PATH, Utils.KEY_DESCRIPTION, Utils.KEY_YEAR_PRODUCED,
				Utils.KEY_COUNTRY_PRODUCED, Utils.KEY_DOORS_AND_PLACES, Utils.KEY_MAX_SPEED, Utils.KEY_TYPE_TRANSMISSION,
				Utils.KEY_DRIVE_UNIT, Utils.KEY_FUEL_TYPE, Utils.KEY_FUEL_TANK_CAPACITY, Utils.KEY_MIDDLE_PRICE,
				Utils.KEY_ENGINE, Utils.KEY_ENGINE_DESCR, Utils.KEY_SUSPENSION_DESCR, Utils.KEY_TRANSMISSION_DESCR,
				Utils.KEY_BRAKE_SYSTEM_DESCR, Utils.KEY_WHEELS_TIRES_DESCR, Utils.KEY_ELECTRICAL_EQUIPMENT,
			}, Utils.KEY_ID + "=?", new String[]{String.valueOf(id)},
			null, null,
			null, null);
		Car car = new Car();
		if (cursor != null) {
			try {
				cursor.moveToFirst();
				int idCar = cursor.getColumnIndex(Utils.KEY_ID);
				int idModel = cursor.getColumnIndex(Utils.KEY_MODEL);
				int idImagePath = cursor.getColumnIndex(Utils.KEY_IMAGE_PATH_SECOND);
				int idVideoPath = cursor.getColumnIndex(Utils.KEY_VIDEO_PATH);
				int idDescription = cursor.getColumnIndex(Utils.KEY_DESCRIPTION);
				int idYear = cursor.getColumnIndex(Utils.KEY_YEAR_PRODUCED);
				int idCountry = cursor.getColumnIndex(Utils.KEY_COUNTRY_PRODUCED);
				int idDoorAndPlaces = cursor.getColumnIndex(Utils.KEY_DOORS_AND_PLACES);
				int idMaxSpeed = cursor.getColumnIndex(Utils.KEY_MAX_SPEED);
				int idTransmission = cursor.getColumnIndex(Utils.KEY_TYPE_TRANSMISSION);
				int idDriveUnit = cursor.getColumnIndex(Utils.KEY_DRIVE_UNIT);
				int idFuelType = cursor.getColumnIndex(Utils.KEY_FUEL_TYPE);
				int idFuelTankCapacity = cursor.getColumnIndex(Utils.KEY_FUEL_TANK_CAPACITY);
				int idMiddlePrice = cursor.getColumnIndex(Utils.KEY_MIDDLE_PRICE);
				int idEngine = cursor.getColumnIndex(Utils.KEY_ENGINE);
				int idEngineDesc = cursor.getColumnIndex(Utils.KEY_ENGINE_DESCR);
				int idSuspensionDesr = cursor.getColumnIndex(Utils.KEY_SUSPENSION_DESCR);
				int idTransmissionDesr = cursor.getColumnIndex(Utils.KEY_TRANSMISSION_DESCR);
				int idBrakeSystemDesc = cursor.getColumnIndex(Utils.KEY_BRAKE_SYSTEM_DESCR);
				int idWheelsTires = cursor.getColumnIndex(Utils.KEY_WHEELS_TIRES_DESCR);
				int idElectricalEquipment = cursor.getColumnIndex(Utils.KEY_ELECTRICAL_EQUIPMENT);

				car.setId(cursor.getInt(idCar));
				car.setModel(cursor.getString(idModel));
				car.setImagePathSecond(cursor.getInt(idImagePath));
				car.setVideoPath(cursor.getInt(idVideoPath));
				car.setDescription(cursor.getString(idDescription));
				car.setYearProduced(cursor.getString(idYear));
				car.setCountryProduced(cursor.getString(idCountry));
				car.setCountDoorsAndPlaces(cursor.getString(idDoorAndPlaces));
				car.setMaxSpeed(cursor.getString(idMaxSpeed));
				car.setTypeTransmission(cursor.getString(idTransmission));
				car.setDriveUnit(cursor.getString(idDriveUnit));
				car.setFuelType(cursor.getString(idFuelType));
				car.setFuelTankCapacity(cursor.getString(idFuelTankCapacity));
				car.setMiddlePrice(cursor.getString(idMiddlePrice));
				car.setEngine(cursor.getString(idEngine));
				car.setEngineDescr(cursor.getString(idEngineDesc));
				car.setSuspensionDescr(cursor.getString(idSuspensionDesr));
				car.setTransmissionDescr(cursor.getString(idTransmissionDesr));
				car.setBrakeSystemDescr(cursor.getString(idBrakeSystemDesc));
				car.setWheelsTiresDescr(cursor.getString(idWheelsTires));
				car.setElectricalEquipment(cursor.getString(idElectricalEquipment));

			} finally {
				cursor.close();
			}
		}
		return car;
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

	public void addUser(User user) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues contentValues = new ContentValues();
		contentValues.put(UtilsUsers.KEY_NAME, user.getName());
		contentValues.put(UtilsUsers.KEY_EMAIL, user.getEmail());
		contentValues.put(UtilsUsers.KEY_PASSWORD, user.getPassword());

		db.insert(UtilsUsers.TABLE_NAME, null, contentValues);
		db.close();
	}

	public int getUserByEmail(String email) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(UtilsUsers.TABLE_NAME,
			new String[]{Utils.KEY_ID},
			UtilsUsers.KEY_EMAIL + "=?",
			new String[]{email},
			null, null, null, null);

		int id = 0;

		if (cursor.moveToFirst()) {
			try {
				int idIndex = cursor.getColumnIndex(UtilsUsers.KEY_ID);
				id = cursor.getInt(idIndex);
			} finally {
				cursor.close();
			}
		}

		return id;
	}

}
