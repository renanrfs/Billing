package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class Invoice extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	public Date date;

	public String validate;

	public String reference;

	public String isencaoIVA;

	public String description;

	public Double retention;

	public String currency;

	@ManyToOne(cascade = CascadeType.ALL)
	public Client client;

	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
	public List<Item> items;

	public static Finder<Long, Invoice> find = new Finder<Long, Invoice>(
			Long.class, Invoice.class);

	public static List<Invoice> all() {
		return find.all();
	}

	public static void create(Invoice invoice) {
		invoice.save();
	}

	public static void update(Invoice invoice) {
		invoice.update();
	}

	public static Invoice get(Long id) {
		return find.ref(id);
	}

	public static void delete(Long id) {
		get(id).delete();
	}

}
