package app.prod.src.backend_garage.entity;

public enum PaymentType {
	
	PER_HOUR("por hora"),
	DAILY("Diário"),
	WEEKLY("Semanal"),
	MONTHLY("Mensal");
	
	private String typePayment;

	PaymentType(String typePayment){
		this.typePayment = typePayment;
	}
	
	public String gettypePayment() {
		return typePayment;
	}
}
