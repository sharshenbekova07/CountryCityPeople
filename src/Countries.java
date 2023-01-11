import java.util.Scanner;

public class Countries {
    private Integer id;
    private String name;
    private Integer code;
    private Integer population;
    private String president;

    Scanner scan = new Scanner(System.in);
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }
    @Override
    public String toString(){
        return "id:"+this.id +"\n"+
                "name:"+this.name+"\n"+
                "code:"+ this.code+"\n"+
                "president_name:"+this.president+"\n"+
                "population:"+this.population+"\n";
    }


}
