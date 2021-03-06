package fr.layer4.payment4j.gateways.litle;

import fr.layer4.payment4j.CreditCard;
import fr.layer4.payment4j.CreditCardType;
import fr.layer4.payment4j.gateways.AbstractTransactionGatewayTest;

public class LitleTransactionGatewayTest extends AbstractTransactionGatewayTest {

	public void data() {

		// The expiration date must be set to the present date or later:
		// American Express Test Card 370000000000002
		// Discover Test Card 6011000000000012
		// Visa Test Card 4007000000027
		// Second Visa Test Card 4012888818888
		// JCB 3088000000000017
		// Diners Club/ Carte Blanche 38000000000006

		validCreditCard = new CreditCard().setNumber("4470330769941000")
				.setType(CreditCardType.VISA).setFirstName("John")
				.setLastName("Doe").setMonth(12).setYear(2015)
				.setVerificationValue("000");
		expiredCreditCard = new CreditCard().setNumber("4007000000027")
				.setType(CreditCardType.VISA).setFirstName("John")
				.setLastName("Doe").setMonth(12).setYear(2009)
				.setVerificationValue("000");
		invalidNumberCreditCard = new CreditCard().setNumber("400700027")
				.setType(CreditCardType.VISA).setFirstName("John")
				.setLastName("Doe").setMonth(12).setYear(2015)
				.setVerificationValue("000");
		invalidExpirationDateCreditCard = new CreditCard()
				.setNumber("4007000000027").setType(CreditCardType.VISA)
				.setFirstName("John").setLastName("Doe").setMonth(12)
				.setYear(1990).setVerificationValue("000");
		incorrectNumberCreditCard = new CreditCard().setNumber("4007000000028")
				.setType(CreditCardType.VISA).setFirstName("John")
				.setLastName("Doe").setMonth(12).setYear(2015)
				.setVerificationValue("000");
		incorrectVerificationCodeCreditCard = new CreditCard()
				.setNumber("4007000000027").setType(CreditCardType.VISA)
				.setFirstName("John").setLastName("Doe").setMonth(12)
				.setYear(2015).setVerificationValue("001");
		invalidVerificationCodeCreditCard = new CreditCard()
				.setNumber("4007000000027").setType(CreditCardType.VISA)
				.setFirstName("John").setLastName("Doe").setMonth(12)
				.setYear(2015).setVerificationValue("00");
	}

	public void init() {
		LitleGateway gateway = LitleGateway.build();
		this.gateway = gateway;
		transactionGateway = gateway.transaction();

		invalidCredentialsTransactionGateway = LitleGateway.build()
				.transaction();
	}
}
