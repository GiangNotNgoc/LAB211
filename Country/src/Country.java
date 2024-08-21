
public class Country {
    private String code;
    private String name;
    private float area;

    public Country() {
    }

    public Country(String code, String name, float area) {
        this.code = code;
        this.name = name;
        this.area = area;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }
    
    public void display(){
        System.out.format("%-16s %-16s %-16s", getCode(), getName(), getArea());
    }
    
}
