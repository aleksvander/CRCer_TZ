package ru.intf.modelJPA;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * Реализация сущности Cat
 * @author Новотельнов А.Д.
 * @version 1.0
 */
@Entity
@Table(name="cat")
@NamedQueries(value= {
		@NamedQuery(name="Cat.findAll", query="SELECT c FROM Cat c"),
		//@NamedQuery(name="Cat.findById", query="SELECT c FROM Cat c, IN(c.menus) m WHERE m.id = :pId")
		@NamedQuery(name="Cat.findById", query="SELECT c FROM Cat c WHERE c.id = :pId")
})
public class Cat implements Serializable {
	private static final long serialVersionUID = -6548863402225847846L;

	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", menus=" + menus + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String name;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="cat", fetch=FetchType.LAZY)
	private List<Menu> menus;

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Cat() {
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

	public Menu addMenus(Menu menus) {
		getMenus().add(menus);
		menus.setCat(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setCat(null);

		return menus;
	}

}