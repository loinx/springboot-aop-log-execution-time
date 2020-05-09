/**
 * 
 */
package com.loinx.spring.aop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author public
 *
 */

@Data
@NoArgsConstructor
@Entity
public class UserModel {

	@Id
	private String id;

	private String name;

	private int age;

}
