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
		mercedesAmgGt = new Car(R.drawable.merc_amg_gt, R.drawable.merc_amg_gt_2, R.raw.merc_amg_gt,
			"Mercedes-AMG GT", "Mercedes-AMG GT - це спортивний автомобіль, який вперше був представлений у " +
			"2014 році. Його виробляє німецький автовиробник Mercedes-Benz. Автомобіль доступний " +
			"у двох варіантах кузова: купе та кабріолет.", "2014",
			"Німеччина", "2 двері і 4 місця", "310 км/год",
			"Автоматична ", "Повний", "Бензин", "66 літрів",
			"1 084 834$", "sport", "V8 M178",
			"На вибір, автомобіль оснащується бітурбованими 4.0 л двигуном V8 M178 BlueDIRECT, що розвиває два варіанти потужності : 462 (600 Нм ) і 510 к.с (650 Нм ). На силовому агрегаті встановлюються головки циліндрів із цирконієвим сплавом, завдяки чому зменшується тертя та підвищується коефіцієнт теплопровідності. У двигуні застосовується технологія мастила з сухим картером, як і в Mercedes-Benz SLS AMG . Швидкість розгону AMG GT S від 0 до 60 миль/година становить 3,8 секунд  .\n" +
				"Мотор, кермо та підвіску можна налаштувати під стиль водіння. Для цього передбачені кілька варіантів - individual , comfort , race , sport і sport.\n" +
				"Екстремальна версія в кузові купе Mercedes-AMG GT R оснащується бітурбованим 4-літровим бензиновим двигуном із прямим упорскуванням палива. Потужність силового агрегату складає 430 кВт (585 л.с.). Швидкість розгону від 0 до 100 км/год становить 3,6 секунди. Максимальна швидкість становить 318 км/год.\n" +
				"Версії в кузові купе оснащуються тим же бітурбованим двигуном, що і купе, але з модифікованими налаштуваннями. Продуктивність базової модифікації складає 476 к.с., топової (AMG GT C Roadster) - 557 кінських сил.",
			"AMG GT реалізує переднє середньомоторне, задньопривідне компонування. Двигун розташований усередині колісної бази автомобіля. Шасі спорткара виготовляється із сплаву алюмінію, капот із магнію, а кришка багажника зі сталі, подвійні поперечні важелі спереду та ззаду із кованого алюмінію . Вага автомобіля складає близько 1629 кг.\n" +
				"Модифікація AMG GT C оснащується повнокерованим шасі та адаптивною підвіскою. У базовій версії родстера встановлений диференціал, що самоблокується, в AMG GT C - електроннокерований",
			"Потужність силового агрегату, встановленого на автомобілі Mercedes-AMG GT, передається на задні колеса через роботизовану преселективну 7-ступінчасту коробку AMG SPEEDSHIFT DCT з подвійним зчепленням на диференціал обмеженого ковзання, що перекочувала в удосконаленому вигляді з AMG . Розважування складає 47:53 на користь задньої частини.\n" +
				"Модифікації в кузові родстер оснащуються тією ж 7-ступінчастою роботизованою АКПП, але з новою програмою управління і зміненими передавальними числами: перший ступінь став довшим, а вища (сьома) і головна передача — коротша.",
			"на всіх модифікація автомобіля AMG GT встановлена \u200B\u200Bвисокопродуктивна гальмівна система. Базова версія AMG GT оснащується вентильованими перфорованими гальмівними дисками діаметром 360 мм з обох боків. На модифікацію з літерою «S» встановлюються гальмівні диски діаметром 390 мм спереду і 360 мм ззаду. Керамічна високопродуктивна композитна гальмівна система, що має меншу вагу, більш тривалий термін служби, доступна для обох моделей як опція. У такому варіанті в передній частині автомобіля встановлюються гальмівні диски діаметром 402 мм, а в задній - 360 мм.\n" +
				"Модифікація Mercedes-AMG GT R у базовій комплектації оснащується вентильованими перфорованими гальмівними дисками діаметром 390 мм спереду та 360 мм ззаду. Як і базовому купе AMG GT, даної версії доступна високопродуктивна керамічна гальмівна система (на замовлення).\n" +
				"Версії в кузові родстер оснащуються тією ж гальмівною системою, що і AMG GT / AMG GT S: у базовому варіанті GT Roadtser встановлені перфоровані гальмівні диски діаметром 360 мм з обох боків автомобіля, в топовій версії AMG GT C встановлені ті ж диски, але діаметром мм спереду та 360 мм ззаду",
			"Як у кузові купе, так і як родстер, автомобіль оснащується 19-дюймовими передніми (9.0 J x 19) і 19 (11 J x 19) або 20-дюймовими (12.0 J x 20) задніми литими дисками з червоними гальмівними супортами.\n" +
				"У базовій версії автомобіля в кузові родстер встановлюються широкопрофільні шини розміром 255/35 R 19 спереду та 295/35 R 19 ззаду. У модифікації AMG GT C Roadtser спереду встановлюються шини розміром 265/35 R19, ззаду - 305/30 R 20",
			"Автомобіль Mercedes-AMG GT оснащений адаптивною AMG підвіскою, 3-етапною системою AMG ESP , парктрониками, системою об'ємного звучання Burmester , технологією Keyless-Go , системою COMAND , камерою заднього виду, системою Collision Prevention Assist PLUS , кріслами AMG 8 подушками безпеки, 2-зональним клімат-контролем THERMOTRONIC , круїз-контролем з технологією SPEEDTRONIC та світлодіодними фарами.");

		cars.add(mercedesAmgGt);
	}

	public ArrayList<Car> getArrayList() {
		return this.cars;
	}
}
