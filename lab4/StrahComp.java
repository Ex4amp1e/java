package javalaba4;

public class StrahComp extends Organisation{
    
    private int strahVypl;
    
    public StrahComp(String type, String name, int chisRab, boolean gos, int strahVypl){
        super("Страховая компания",name,chisRab,gos);
        this.strahVypl=strahVypl;
    }

    @Override
    public String getField(){
        return "Страховая выплата: "+this.strahVypl;
    } 
}
