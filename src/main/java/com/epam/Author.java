package com.epam;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {
    @JsonProperty
    private long authorId;
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
            return "Name is: " + first + " " + second;
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
    }

    @JsonProperty
    private String authorDescription;

    public Author() {
    }

    public Author(long authorId, Name authorName, String nationality, Birth birth, String authorDescription) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.nationality = nationality;
        this.birth = birth;
        this.authorDescription = authorDescription;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
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
}