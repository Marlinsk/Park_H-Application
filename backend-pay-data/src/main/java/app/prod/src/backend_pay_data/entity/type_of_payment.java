package app.prod.src.backend_pay_data.entity;

public enum type_of_payment {
	
	PER_HOUR("por hora"),
	DAILY("Diário"),
	WEEKLY("Semanal"),
	MONTHLY("Mensal");
	
	private String typePay;

	type_of_payment(String typePay) {
		this.typePay = typePay;
	}

	public String getTypePay() {
		return typePay;
	}
}
