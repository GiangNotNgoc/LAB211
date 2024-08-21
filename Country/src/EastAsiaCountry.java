
public class EastAsiaCountry extends Country{
    private String terrain;

    public EastAsiaCountry() {
    }

    public EastAsiaCountry(String code, String name, float area, String terrain) {
        super(code, name, area);
        this.terrain = terrain;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    @Override
    public void display() {
        super.display(); 
        System.out.format(" %-16s\n", getTerrain());
    }

}
