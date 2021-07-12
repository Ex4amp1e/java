package javalaba4;

public class StroiComp extends Organisation{
    
    private int sooruzh;
    
    public StroiComp(String type, String name, int chisRab, boolean gos,int sooruzh){
        super("Строительная компания",name,chisRab,gos);
        this.sooruzh=sooruzh;
    }

    @Override
    public String getField(){
        return "Построенных сооружений: "+Integer.toString(this.sooruzh);
    } 
}
