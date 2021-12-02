package com.nick.webdynamics2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long parent;
	
	private String name;
	
	@JsonIgnore
	@ManyToOne
	private Category parentCat;

	@OneToMany(mappedBy="parentCat")
	private Set<Category>childSet=new HashSet<Category>();
	
	
	
	
//	@Override
//	public String toString() {
//		return "Category{" +
//				       "id=" + id +
//				       ", parent=" + parent +
//				       ", name='" + name + '\'' +
//				       '}';
//	}
	
//	@Override
//	public String toString() {
//		return "Category{" +
//				       "id=" + id +
//				       ", parent=" + parent +
//				       ", name='" + name + '\'' +
//				       '}';
//	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (! (o instanceof Category)) {
			return false;
		}
		Category category = (Category) o;
		return getId().equals(category.getId()) &&
				       Objects.equals(getParent(), category.getParent()) &&
				       getName().equals(category.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId(), getParent(), getName());
	}
	
	@Override
	public String toString() {
		return "\nCategory{" +
				       "id=" + id +
				       ", parent=" + parent +
				       ", name='" + name + '\'' +
				       ", \n\tchildSet=" + childSet +
				       '}';
	}
	
	
}
