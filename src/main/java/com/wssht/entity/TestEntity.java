
package com.wssht.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="test")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class TestEntity implements Serializable{

	private String id;
	
	private String name;
	
	private int age;

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    @Column(name="name",columnDefinition="varchar(32)")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
   @Column(columnDefinition="int(4)")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}