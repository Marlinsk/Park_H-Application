package app.prod.src.backend_garage.entity;

public enum StateName {
	AC("Acre"), 
    AL("Alagoas"), 
    AP("Amapá"),
    AM("Amazônia"),
    BA("Bahia"),
    CE("Ceará"),
    ES("Espiríto Santo"),
    GO("Goiás"),
    MA("Maranhão"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    MG("Minas Gerais"),
    PA("Pará"),
    PB("Paraíba"),
    PR("Paraná"),
    PE("Pernambuco"),
    PI("Piauí"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RS("Rio Grande do Sul"),
    RO("Rondônia"),
    RR("Roraima"),
    SC("Santa Catarina"),
    SP("São Paulo"),
    SE("Sergipe"),
    TO("Tocantins"),
    DF("Distrito Federal");

	private String fullnameState;

	StateName(String fullnameState) {
		this.fullnameState = fullnameState;
	}

	public String getfullnameState() {
		return fullnameState;
	}
}
