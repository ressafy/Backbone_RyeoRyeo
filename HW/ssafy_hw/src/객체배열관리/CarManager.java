package 객체배열관리;

public class CarManager {
	// 관리하는 자동차 정보 배열 크기 100
	private Car[] carList = new Car[100];
	// 현재 등록된 자동차 정보 수
	private int size = 0;

	// 자동차 등록
	// 전체의 개수가 100개가 넘지 않을 때 저장하고 true를 반환 넘었다면 false를 반환
	public boolean add(Car car) {
		// 빈칸의 개수가 1개라고 생각하지 말것
		if(size < 100) {
			carList[size++] = car;
			return true;
		} else {
			return false;
		}
	}

	// 현재 등록된 자동차 반환
	public Car[] getList() {

		Car[] result = new Car[size];

		for (int i = 0; i<this.size; i++) {
			result[i] = carList[i];
		}

		return result;
	}

	// 해당 인자를 가진 자동차 배열 반환
	public Car[] searchByModelName(String modelName) {
		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if (carList[i].getModelName().contains(modelName))
				cnt++;
		}

		Car[] result = new Car[cnt];
		int idx = 0;
		for (int i = 0; i < this.size; i++) {
			if (carList[i].getModelName().contains(modelName))
				result[idx++] = carList[i];
		}
		return result;
	}
}