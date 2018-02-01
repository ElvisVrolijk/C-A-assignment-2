package com.company.models;

/**
 * Basic representation on a patient.
 */
public class Patient {
    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////
    private String fullName;
    private int age;
    private String diagnosis;

    /**
     * Constructor
     * @param fullName Full name of the patient.
     * @param age The age of the patient.
     * @param diagnosis The doctor's diagnosis of the patient.
     */
    public Patient(String fullName, int age, String diagnosis) {
        this.fullName = fullName;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Name: " + fullName + "\nAge: " + age + "\nDiagnosis: " + diagnosis;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters
    ///////////////////////////////////////////////////////////////////////////
    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Setters
    ///////////////////////////////////////////////////////////////////////////
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
