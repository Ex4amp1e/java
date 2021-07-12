package javalaba4;

/**
 *
 * @author Jz
 */
public class Admin extends Cadr{
    private int Kof, zp;
    
    public Admin(String Fam,int Age, boolean Eng, int Kof){
    super("Администратор",Fam,Age,Eng);
    this.Kof=Kof;
    }
    
    public int getKof() {
        return Kof;
    }
    
    @Override
    public String zp() {
        this.zp=this.getAge()*this.getKof()*50;
        return Integer.toString(this.zp)+"$";
    }
}
