package embeddableExample;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String publicAddress;
	private String complement;
	
	public String getPublicAddress() {
		return publicAddress;
	}
	public void setPublicAddress(String publicAddress) {
		this.publicAddress = publicAddress;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	
}

