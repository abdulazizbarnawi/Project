
package models;

public class Place {
 private int    id ,area;
private String    name ,    info ,best;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getBest() {
        return best;
    }

    public void setBest(String best) {
        this.best = best;
    }

    public Place(int id, int area, String name, String info, String best) {
        this.id = id;
        this.area = area;
        this.name = name;
        this.info = info;
        this.best = best;
    }

    public Place() {
    }

   
}
