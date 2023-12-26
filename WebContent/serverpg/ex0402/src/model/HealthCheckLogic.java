package model;

public class HealthCheckLogic {
	public void execute(Health health) {
		//BMIを計算して設定
		double weight = health.getWeight();
		double height = health.getHeight();
		double bmi    = weight / (height / 100.0 * height / 100.0);
		health.setBmi(bmi);
		
		
		//BMI数値から体型を判断して設定
		String bodyType;
		if (bmi < 18.5) {
			bodyType = "瘦せ型";
		}
		else if (bmi < 25){
			bodyType = "普通";
		}
		else {
			bodyType = "肥満";
		}
		health.setBodyType(bodyType);
		
	}
}
