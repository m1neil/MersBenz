package database;

public class Car {
	private int id;
	private int imagePath;
	private int imagePathSecond;
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
	private String engine;
	private String engineDescr;
	private String suspensionDescr;
	private String transmissionDescr;
	private String brakeSystemDescr;
	private String wheelsTiresDescr;
	private String electricalEquipment;

	public Car() {
	}

	public Car(int imagePath, int imagePathSecond, int videoPath, String model, String description, String yearProduced,
				  String countryProduced, String countDoorsAndPlaces, String maxSpeed,
				  String typeTransmission, String driveUnit, String fuelType, String fuelTankCapacity,
				  String middlePrice, String category, String engine, String engineDescr,
				  String suspensionDescr, String transmissionDescr, String brakeSystemDescr,
				  String wheelsTiresDescr, String electricalEquipment) {
		this.imagePath = imagePath;
		this.imagePathSecond = imagePathSecond;
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
		this.engine = engine;
		this.engineDescr = engineDescr;
		this.suspensionDescr = suspensionDescr;
		this.transmissionDescr = transmissionDescr;
		this.brakeSystemDescr = brakeSystemDescr;
		this.wheelsTiresDescr = wheelsTiresDescr;
		this.electricalEquipment = electricalEquipment;
	}

	public Car(int id, int imagePath, int imagePathSecond, int videoPath, String model, String description,
				  String yearProduced, String countryProduced, String countDoorsAndPlaces,
				  String maxSpeed, String typeTransmission, String driveUnit, String fuelType,
				  String fuelTankCapacity, String middlePrice, String category,  String engine,
				  String engineDescr, String suspensionDescr, String transmissionDescr,
				  String brakeSystemDescr, String wheelsTiresDescr, String electricalEquipment) {
		this.id = id;
		this.imagePath = imagePath;
		this.imagePathSecond = imagePathSecond;
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
		this.engine = engine;
		this.engineDescr = engineDescr;
		this.suspensionDescr = suspensionDescr;
		this.transmissionDescr = transmissionDescr;
		this.brakeSystemDescr = brakeSystemDescr;
		this.wheelsTiresDescr = wheelsTiresDescr;
		this.electricalEquipment = electricalEquipment;
	}

	public int getImagePathSecond() {
		return imagePathSecond;
	}

	public void setImagePathSecond(int imagePathSecond) {
		this.imagePathSecond = imagePathSecond;
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

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getEngineDescr() {
		return engineDescr;
	}

	public void setEngineDescr(String engineDescr) {
		this.engineDescr = engineDescr;
	}

	public String getSuspensionDescr() {
		return suspensionDescr;
	}

	public void setSuspensionDescr(String suspensionDescr) {
		this.suspensionDescr = suspensionDescr;
	}

	public String getTransmissionDescr() {
		return transmissionDescr;
	}

	public void setTransmissionDescr(String transmissionDescr) {
		this.transmissionDescr = transmissionDescr;
	}

	public String getBrakeSystemDescr() {
		return brakeSystemDescr;
	}

	public void setBrakeSystemDescr(String brakeSystemDescr) {
		this.brakeSystemDescr = brakeSystemDescr;
	}

	public String getWheelsTiresDescr() {
		return wheelsTiresDescr;
	}

	public void setWheelsTiresDescr(String wheelsTiresDescr) {
		this.wheelsTiresDescr = wheelsTiresDescr;
	}

	public String getElectricalEquipment() {
		return electricalEquipment;
	}

	public void setElectricalEquipment(String electricalEquipment) {
		this.electricalEquipment = electricalEquipment;
	}
}
