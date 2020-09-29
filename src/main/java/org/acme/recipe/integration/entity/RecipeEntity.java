/*
 * (c)Copyright Since 2020, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.recipe.integration.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "recipes")
@Data
//@Builder
public class RecipeEntity extends PanacheEntityBase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  public Integer id;

  @Column(name = "title")
  public String title;

  @Column(name = "making_time")
  public String makingTime;

  @Column(name = "serves")
  public String serves;

  @Column(name = "ingredients")
  public String ingredients;

  @Column(name = "cost")
  public Integer cost;

  @Column(name = "created_at")
  public Timestamp createdAt;

  @Column(name = "updated_at")
  public Timestamp updatedAt;
}
