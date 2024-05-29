// Estrutura de Dados Perfeito - DTO

// https://www.devmedia.com.br/diferenca-entre-os-patterns-po-pojo-bo-dto-e-vo/28162#:~:text=Data%20Transfer%20Object%20%E2%80%93%20DTO,dos%20dados%20(model%20layer).

// Recomendo aprender sobre conceitos de Design Patterns. Eu estou para ver esse conceito no curso do Otavio Luiz, em Python.

public class Address {
	private String street;
	private String streetExtra;
	private String city;
	private String state;
	private String zip;
	
	public Address(String street, String streetExtra, String city, String state, String zip) {
		this.street = street;
		this.streetExtra = streetExtra;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetExtra() {
		return streetExtra;
	}

	public void setStreetExtra(String streetExtra) {
		this.streetExtra = streetExtra;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
}
