package com.epam.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Author {
    @JsonProperty
    private int authorId;
    @JsonProperty
    private Name authorName;

    public static class Name {
        @JsonProperty
        private String first;
        @JsonProperty
        private String second;

        public Name(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public Name() {
        }

        @Override
        public String toString() {
            return "Name{" +
                    "first='" + first + '\'' +
                    ", second='" + second + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Name name = (Name) o;
            return Objects.equals(first, name.first) &&
                    Objects.equals(second, name.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    @JsonProperty
    private String nationality;
    @JsonProperty
    private Birth birth;

    public static class Birth {
        @JsonProperty
        private String date;
        @JsonProperty
        private String country;
        @JsonProperty
        private String city;

        public Birth(String date, String country, String city) {
            this.date = date;
            this.country = country;
            this.city = city;
        }

        public Birth() {
        }

        @Override
        public String toString() {
            return "Birth{" +
                    "date='" + date + '\'' +
                    ", country='" + country + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Birth birth = (Birth) o;
            return Objects.equals(date, birth.date) &&
                    Objects.equals(country, birth.country) &&
                    Objects.equals(city, birth.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(date, country, city);
        }
    }

    @JsonProperty
    private String authorDescription;

    public Author() {
    }

    public Author(int authorId, Name authorName, String nationality, Birth birth, String authorDescription) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.nationality = nationality;
        this.birth = birth;
        this.authorDescription = authorDescription;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Name getAuthorName() {
        return authorName;
    }

    public void setAuthorName(Name authorName) {
        this.authorName = authorName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Birth getBirth() {
        return birth;
    }

    public void setBirth(Birth birth) {
        this.birth = birth;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public void setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName=" + authorName +
                ", nationality='" + nationality + '\'' +
                ", birth=" + birth +
                ", authorDescription='" + authorDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorId == author.authorId &&
                Objects.equals(authorName, author.authorName) &&
                Objects.equals(nationality, author.nationality) &&
                Objects.equals(birth, author.birth) &&
                Objects.equals(authorDescription, author.authorDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, authorName, nationality, birth, authorDescription);
    }
}