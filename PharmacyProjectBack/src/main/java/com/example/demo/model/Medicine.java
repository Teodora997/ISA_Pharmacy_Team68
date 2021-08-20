package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Medicines")
public class Medicine {

    @Id
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Type")
    private String type;

    @Column(name = "Form")
    private String form;

    @Column(name = "Ingredients")
    private String ingredients;

    @Column(name = "Producer")
    private String producer;

    @Column(name = "Regime")
    private String regime;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Medicine> alternative = new HashSet<Medicine>();

    @Column(name = "Additional")
    private String additional;

    @Column(name = "Points")
    private Integer points;

    public Medicine(Long id, String name, String type, String form, String ingredients, String producer, String regime,
            Set<Medicine> alternative, String additional, Integer points) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.form = form;
        this.ingredients = ingredients;
        this.producer = producer;
        this.regime = regime;
        this.alternative = alternative;
        this.additional = additional;
        this.points = points;
    }

    public Medicine(){

    }
    
    public Medicine(Long id, String name, String type, String form, String ingredients, String producer, String regime,
    Set<Medicine> alternative, String additional) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.form = form;
        this.ingredients = ingredients;
        this.producer = producer;
        this.regime = regime;
        this.alternative = alternative;
        this.additional = additional;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Set<Medicine> getAlternative() {
        return alternative;
    }

    public void setAlternative(Set<Medicine> alternative) {
        this.alternative = alternative;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

   
}
