package controllers;

import models.Invoice;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import services.BillingService;
import views.html.invoiceEdit;
import views.html.invoiceList;

public class BillingController extends Controller {

	static Form<Invoice> InvoiceForm = Form.form(Invoice.class);

	public static Result invoices() {
		return ok(invoiceList.render(Invoice.all()));
	}

	public static Result newInvoice() {
		Form<Invoice> Invoice = InvoiceForm.bindFromRequest();
		/*
		 * if has errors
		 */
		if (Invoice.hasErrors()) {
			return badRequest(invoiceEdit.render(InvoiceForm));
		}

		Invoice invoiceEntity = Invoice.get();
		if(invoiceEntity.id > 0) {
			BillingService.update(invoiceEntity);
		} else {
			BillingService.create(invoiceEntity);
		}

		return ok(invoiceEdit.render(InvoiceForm));
	}

	public static Result editInvoice(Long id) {
		Invoice invoice = BillingService.get(id);
		Form<Invoice> invoicef = InvoiceForm.fill(invoice);
		return ok(invoiceEdit.render(invoicef));
	}

	public static Result deleteInvoice(Long id) {
		BillingService.delete(id);
		return ok(invoiceList.render(Invoice.all()));
	}
}
