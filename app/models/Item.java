package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Item extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	public String reference;

	public String description;

	public Double price;

	public Integer quantity;

	public Integer unit;

	public Float iva;

	public Float descount;

	@ManyToOne(cascade = CascadeType.ALL)
	public Invoice invoice;

}
