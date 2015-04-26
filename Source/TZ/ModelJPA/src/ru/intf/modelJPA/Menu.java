package ru.intf.modelJPA;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Реализация сущности Menu
 * @author Новотельнов А.Д.
 * @version 1.0
 */
@Entity
@Table(name="menu")
@NamedQueries(value= {
		@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m"), //Тут используется EJB QUERY
		@NamedQuery(name="Menu.findByColumn", query="SELECT m FROM Menu m WHERE :pNC LIKE :pValue") 
	})
public class Menu implements Serializable {
	private static final long serialVersionUID = -7195663923864688737L;

	public Menu(String name, Float price, Cat cat) {
		super();
		this.name = name;
		this.price = price;
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", price=" + price
				+ "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length = 45)
	private String name;

	@Column(name = "Price", nullable = true)
	private Float price;

	//bi-directional many-to-one association to Cat
	@ManyToOne
	@JoinColumn(name = "Catid", nullable = true)
	private Cat cat;

	public Menu() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		/*if (price <= 0) {
			this.price = -1f;
		} else {*/
			this.price = price;
		/*}*/
	}

	public Cat getCat() {
		return this.cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

}