package com.nick.webdynamics2.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	private static final long serialVersionUID=1L;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "country")
	private Set<State>states = new HashSet<State>();
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (! (o instanceof Country)) {
			return false;
		}
		Country country = (Country) o;
		return getId().equals(country.getId()) &&
				       getName().equals(country.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName());
	}
	
	@Override
	public String toString() {
		return "Country{" +
				       "id=" + id +
				       ", name='" + name + '\'' +
				       '}';
	}
}
