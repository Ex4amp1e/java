package javalaba4;

/**
 *
 * @author Jz
 */
public class Rab extends Cadr {

    private int Kof, zp;

    public Rab(String Fam,int Age, boolean Eng, int Kof){
    super("Рабочий",Fam,Age,Eng);
    this.Kof=Kof;
    }

    
    
    public int getKof() {
        return Kof;
    }
    
    @Override
    public String zp() {
        this.zp=this.getAge()*this.getKof()*120;
        return Integer.toString(this.zp)+"руб";
    }

}
