package dto;

import java.util.Objects;

public class PassportDto {
    private String firstName;
    private String lastName;
    private int initId;
    private String personalId;

    public PassportDto(String firstName, String lastName, int initId, String personalId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.initId = initId;
        this.personalId = personalId;
    }

    public PassportDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getInitId() {
        return initId;
    }

    public void setInitId(int initId) {
        this.initId = initId;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassportDto that = (PassportDto) o;
        return initId == that.initId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(personalId, that.personalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, initId, personalId);
    }
}
