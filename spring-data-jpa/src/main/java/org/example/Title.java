package org.example;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Title {

    private String originalName;
    private String frenchName;

    public Title() {
    }

    public Title(String originalName, String frenchName) {
        this.originalName = originalName;
        this.frenchName = frenchName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getFrenchName() {
        return frenchName;
    }

    public void setFrenchName(String frenchName) {
        this.frenchName = frenchName;
    }

    @Override
    public String toString() {
        return "Title{" +
                "originalName='" + originalName + '\'' +
                ", frenchName='" + frenchName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Title title = (Title) o;

        if (!Objects.equals(originalName, title.originalName)) return false;
        return Objects.equals(frenchName, title.frenchName);
    }

    @Override
    public int hashCode() {
        int result = originalName != null ? originalName.hashCode() : 0;
        result = 31 * result + (frenchName != null ? frenchName.hashCode() : 0);
        return result;
    }
}
