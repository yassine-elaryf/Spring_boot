package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produit {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
@NotNull
@Size(min=4, max=15)
	private String designation;
@DecimalMin("50")
	private double prix;
	private int quantite;
}
