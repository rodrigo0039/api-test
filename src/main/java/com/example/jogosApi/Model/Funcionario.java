package com.example.jogosApi.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name ="funcionario")
public class Funcionario {	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "nome")
		private String nome;
		private double salario;
		@Temporal(TemporalType.DATE)
		private Date dataEntrada;
		@Temporal(TemporalType.DATE)
		private Date dataSaida;
		private String cargo;
		@Embedded
		private Endereco endereco;
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public double getSalario() {
			return salario;
		}
		public void setSalario(double salario) {
			this.salario = salario;
		}
		
		public String getCargo() {
			return cargo;
		}
		public void setCargo(String cargo) {
			this.cargo = cargo;
		}
		public Endereco getEndereco() {
			return endereco;
		}
		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Date getDataEntrada() {
			return dataEntrada;
		}
		public void setDataEntrada(Date dataEntrada) {
			this.dataEntrada = dataEntrada;
		}
		public Date getDataSaida() {
			return dataSaida;
		}
		public void setDataSaida(Date dataSaida) {
			this.dataSaida = dataSaida;
		}
		
		
		
}
