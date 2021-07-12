package javalaba4;

public class Zavod extends Organisation {

    private int cehcol;
    
    public Zavod(String type, String name, int chisRab, boolean gos, int cehcol){
        super("Завод",name,chisRab,gos);
        this.cehcol=cehcol;
    }

    @Override
    public String getField(){
        return "Кол-во цехов: "+this.cehcol;
    }
}
