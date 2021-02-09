package com.example.knio.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "informations")
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(value = 36, message = "please enter a valid temperature!")
    @Max(value = 41, message = "please enter a valid temperature")
    private float temperature;

    @ManyToOne
    private User user;

    @NotNull
    private boolean cough;

    @NotNull
    private boolean tired;

    @NotNull
    private boolean headache;

    @NotNull
    private boolean lostOfTaste;

    @NotNull
    private boolean difficultBreathing;

    @NotNull
    private boolean chestPain;

    @NotNull
    private boolean haveBeenAbroad;

    @NotNull
    private boolean soreThroat;

    public Info() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isTired() {
        return tired;
    }

    public void setTired(boolean tired) {
        this.tired = tired;
    }

    public boolean isHeadache() {
        return headache;
    }

    public void setHeadache(boolean headache) {
        this.headache = headache;
    }

    public boolean isLostOfTaste() {
        return lostOfTaste;
    }

    public void setLostOfTaste(boolean lostOfTaste) {
        this.lostOfTaste = lostOfTaste;
    }

    public boolean isDifficultBreathing() {
        return difficultBreathing;
    }

    public void setDifficultBreathing(boolean difficultBreathing) {
        this.difficultBreathing = difficultBreathing;
    }

    public boolean isChestPain() {
        return chestPain;
    }

    public void setChestPain(boolean chestPain) {
        this.chestPain = chestPain;
    }

    public boolean isHaveBeenAbroad() {
        return haveBeenAbroad;
    }

    public void setHaveBeenAbroad(boolean haveBeenAbroad) {
        this.haveBeenAbroad = haveBeenAbroad;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }
}
