package com.nick.webdynamics2.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="city")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class City implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	private static final long serialVersionUID=1L;
	
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;
}
