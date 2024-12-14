package com.di;

// Клас Meteorolog, що реалізує Person і BonusEligible
public class Meteorolog extends Person implements BonusEligible {
    private double bonus;

    // Конструктори
    public Meteorolog() {
        super();
        this.bonus = DEFAULT_BONUS; // Встановити бонус за замовчуванням
    }

    public Meteorolog(String name) {
        super(name);
        this.bonus = DEFAULT_BONUS; // Встановити бонус за замовчуванням
    }

    public Meteorolog(String name, double bonus) {
        super(name);
        setBonus(bonus); // Встановити бонус через метод-сетер
    }

    // Реалізація методів інтерфейсу BonusEligible
    @Override
    public double getBonus() {
        return bonus;
    }

    @Override
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void displayInfo() {
        System.out.println(getFullDetails() + ", Бонус: " + getBonus());
    }
}