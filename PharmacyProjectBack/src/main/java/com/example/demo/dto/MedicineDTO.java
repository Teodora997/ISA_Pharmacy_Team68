package com.example.demo.dto;

public class MedicineDTO {
    public String id;
    public String name;
    public String type;
    public String form;
    public String ingredients;
    public String producer;
    public String regime;
    //public String alternative;
    public String additional;
    public String points;

    public MedicineDTO() {
    }


    public MedicineDTO(String id, String name, String type, String form, String ingredients, String producer,
            String regime, String additional,String points) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.form = form;
        this.ingredients = ingredients;
        this.producer = producer;
        this.regime = regime;
        this.additional = additional;
        this.points=points;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
