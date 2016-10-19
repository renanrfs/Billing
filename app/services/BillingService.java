package services;

import models.Invoice;

public class BillingService {

	public static void create(Invoice invoice) {
		Invoice.create(invoice);
	}

	public static void update(Invoice invoice) {
		Invoice.update(invoice);
	}

	public static Invoice get(Long id) {
		return Invoice.get(id);
	}

	public static void delete(Long id) {
		Invoice.delete(id);
	}

}
