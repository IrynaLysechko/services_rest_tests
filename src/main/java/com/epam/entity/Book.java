package com.epam.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Book {
    @JsonProperty
    private long bookId;
    @JsonProperty
    private String bookName;
    @JsonProperty
    private String bookLanguage;
    @JsonProperty
    private String bookDescription;
    @JsonProperty
    private Additional additional;

    public static class Additional{
        @JsonProperty
        private int pageCount;
        @JsonProperty
        private Size size;

        public static class Size{
            @JsonProperty
            private double height;
            @JsonProperty
            private double width;
            @JsonProperty
            private double length;

            public Size(double height, double width, double length) {
                this.height = height;
                this.width = width;
                this.length = length;
            }
            public Size(){

            }

            @Override
            public String toString() {
                return "Size{" +
                        "height=" + height +
                        ", width=" + width +
                        ", length=" + length +
                        '}';
            }

            public double getHeight() {
                return height;
            }

            public void setHeight(double height) {
                this.height = height;
            }

            public double getWidth() {
                return width;
            }

            public void setWidth(double width) {
                this.width = width;
            }

            public double getLength() {
                return length;
            }

            public void setLength(double length) {
                this.length = length;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Size size = (Size) o;
                return Double.compare(size.height, height) == 0 &&
                        Double.compare(size.width, width) == 0 &&
                        Double.compare(size.length, length) == 0;
            }

            @Override
            public int hashCode() {
                return Objects.hash(height, width, length);
            }
        }


        public Additional(int pageCount, Size size) {
            this.pageCount = pageCount;
            this.size = size;
        }
        public Additional(){
        }

        @Override
        public String toString() {
            return "Additional{" +
                    "pageCount=" + pageCount +
                    ", size=" + size +
                    '}';
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public Size getSize() {
            return size;
        }

        public void setSize(Size size) {
            this.size = size;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Additional that = (Additional) o;
            return pageCount == that.pageCount &&
                    Objects.equals(size, that.size);
        }

        @Override
        public int hashCode() {
            return Objects.hash(pageCount, size);
        }
    }
    @JsonProperty
    private int publicationYear;


    public Book(long bookId, String bookName, String bookLanguage,
                String bookDescription, Additional additional, int publicationYear) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookLanguage = bookLanguage;
        this.bookDescription = bookDescription;
        this.additional = additional;
        this.publicationYear = publicationYear;
    }
    public Book(){

    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Additional getAdditional() {
        return additional;
    }

    public void setAdditional(Additional additional) {
        this.additional = additional;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookLanguage='" + bookLanguage + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", additional=" + additional +
                ", publicationYear=" + publicationYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId &&
                publicationYear == book.publicationYear &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(bookLanguage, book.bookLanguage) &&
                Objects.equals(bookDescription, book.bookDescription) &&
                Objects.equals(additional, book.additional);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookName, bookLanguage, bookDescription, additional, publicationYear);
    }
}
