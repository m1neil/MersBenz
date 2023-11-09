package database;

public class Car {
	private int id;
	private int imagePath;
	private int videoPath;
	private String model;
	private String description;
	private String yearProduced;
	private String countryProduced;
	private String countDoorsAndPlaces;
	private String maxSpeed;
	private String typeTransmission;
	private String driveUnit;
	private String fuelType;
	private String fuelTankCapacity;
	private String middlePrice;
	private String category;

	public Car() {
	}

	public Car(int imagePath, int videoPath, String model, String description, String yearProduced,
				  String countryProduced, String countDoorsAndPlaces, String maxSpeed,
				  String typeTransmission, String driveUnit, String fuelType, String fuelTankCapacity,
				  String middlePrice, String category) {
		this.imagePath = imagePath;
		this.videoPath = videoPath;
		this.model = model;
		this.description = description;
		this.yearProduced = yearProduced;
		this.countryProduced = countryProduced;
		this.countDoorsAndPlaces = countDoorsAndPlaces;
		this.maxSpeed = maxSpeed;
		this.typeTransmission = typeTransmission;
		this.driveUnit = driveUnit;
		this.fuelType = fuelType;
		this.fuelTankCapacity = fuelTankCapacity;
		this.middlePrice = middlePrice;
		this.category = category;
	}

	public Car(int id, int imagePath, int videoPath, String model, String description,
				  String yearProduced, String countryProduced, String countDoorsAndPlaces,
				  String maxSpeed, String typeTransmission, String driveUnit, String fuelType,
				  String fuelTankCapacity, String middlePrice, String category) {
		this.id = id;
		this.imagePath = imagePath;
		this.videoPath = videoPath;
		this.model = model;
		this.description = description;
		this.yearProduced = yearProduced;
		this.countryProduced = countryProduced;
		this.countDoorsAndPlaces = countDoorsAndPlaces;
		this.maxSpeed = maxSpeed;
		this.typeTransmission = typeTransmission;
		this.driveUnit = driveUnit;
		this.fuelType = fuelType;
		this.fuelTankCapacity = fuelTankCapacity;
		this.middlePrice = middlePrice;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getImagePath() {
		return imagePath;
	}

	public void setImagePath(int imagePath) {
		this.imagePath = imagePath;
	}

	public int getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(int videoPath) {
		this.videoPath = videoPath;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getYearProduced() {
		return yearProduced;
	}

	public void setYearProduced(String yearProduced) {
		this.yearProduced = yearProduced;
	}

	public String getCountryProduced() {
		return countryProduced;
	}

	public void setCountryProduced(String countryProduced) {
		this.countryProduced = countryProduced;
	}

	public String getCountDoorsAndPlaces() {
		return countDoorsAndPlaces;
	}

	public void setCountDoorsAndPlaces(String countDoorsAndPlaces) {
		this.countDoorsAndPlaces = countDoorsAndPlaces;
	}

	public String getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getTypeTransmission() {
		return typeTransmission;
	}

	public void setTypeTransmission(String typeTransmission) {
		this.typeTransmission = typeTransmission;
	}

	public String getDriveUnit() {
		return driveUnit;
	}

	public void setDriveUnit(String driveUnit) {
		this.driveUnit = driveUnit;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getFuelTankCapacity() {
		return fuelTankCapacity;
	}

	public void setFuelTankCapacity(String fuelTankCapacity) {
		this.fuelTankCapacity = fuelTankCapacity;
	}

	public String getMiddlePrice() {
		return middlePrice;
	}

	public void setMiddlePrice(String middlePrice) {
		this.middlePrice = middlePrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
