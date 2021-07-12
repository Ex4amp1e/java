package javalaba4;

/**
 *
 * @author Jz
 */
public class Inj extends Cadr{
    private int Kof, zp;
    
            
    public Inj(String Fam,int Age, boolean Eng, int Kof){
    super("Инженер",Fam,Age,Eng);
    this.Kof=Kof;
    }
    
    public int getKof() {
        return Kof;
    }
    
    @Override
    public String zp() {
        this.zp=this.getAge()*this.getKof()*12;
        return Integer.toString(this.zp)+"тыс. руб.";
    }
    
}
