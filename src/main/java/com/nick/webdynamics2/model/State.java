package com.nick.webdynamics2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="state")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class State implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	private static final long serialVersionUID=1L;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (! (o instanceof State)) {
			return false;
		}
		State state = (State) o;
		return getId().equals(state.getId()) &&
				       getName().equals(state.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName());
	}
	
	@Override
	public String toString() {
		return "State{" +
				       "id=" + id +
				       ", name='" + name + '\'' +
				       '}';
	}
}
