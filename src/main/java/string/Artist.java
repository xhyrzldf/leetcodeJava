package string;

/**
 * <p>Description : leetcodeJava
 * <p>Date : 2017/10/26 22:31
 * <p>@author : Matrix [xhyrzldf@foxmail.com]
 */
public class Artist {
    private String name;
    private String nationality;

    public Artist() {
    }

    public Artist(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public Artist setName(String name) {
        this.name = name;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public Artist setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }
}
