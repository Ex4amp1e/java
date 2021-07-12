package javalaba4;
import java.util.ArrayList;
import javalaba4.StrahComp;
import javalaba4.Organisation;
import javalaba4.Zavod;
import javalaba4.StroiComp;

public class Group {
    
    private ArrayList organisations = new ArrayList(); //массив записей (по идее)
   
    public void addStrahComp (String type, String name, int chisRab, boolean gos, int strahVypl) {
           this.organisations.add(new StrahComp (type, name, chisRab, gos, strahVypl));
    }
   
    public void addStroiComp (String type, String name, int chisRab, boolean gos, int sooruzh) {
           this.organisations.add(new StroiComp (type, name, chisRab, gos, sooruzh));
    }
      
    public void addZavod (String type, String name, int chisRab, boolean gos, int cehcol) {
           this.organisations.add(new Zavod (type, name, chisRab, gos, cehcol));
    }
    
    public Organisation getProf(int i){
        return (Organisation) this.organisations.get(i);
    }
    
    
    public int[] findName(String Name){
        int i=0; int n=0; 
        while(i<organisations.size()){
                        Organisation organisation = (Organisation) organisations.get(i);
                        boolean d;
                        d=findString(organisation.getName(), Name);
                        if (d){n++;
                            }
                        i++;
                        }
        
        int[] a=new int[n];
        i=0; n=0;
        while(i<organisations.size()){
                        Organisation organisation = (Organisation) organisations.get(i);
                        boolean d;
                        d=findString(organisation.getName(), Name);
                        if (d){a[n]=i; n++;
                        }
                        i++;
                        }
        return a;
    }
    
    public int[] findType(String Name){
        int i=0; int n=0; 
        while(i<organisations.size()){
                        Organisation organisation = (Organisation) organisations.get(i);
                        boolean d;
                        d=organisation.getType().equals(Name);
                        if (d){n++;
                            }
                        i++;
                        }
        
        int[] a=new int[n];
        i=0; n=0;
        while(i<organisations.size()){
                        Organisation organisation = (Organisation) organisations.get(i);
                        boolean d;
                        d=organisation.getType().equals(Name);
                        if (d){a[n]=i; n++;
                        }
                        i++;
                        }
        return a;
    }
    
    public int[] findchisRab(int Name){int i=0; int n=0; 
        while(i<organisations.size()){
                        Organisation organisation = (Organisation) organisations.get(i);
                        if (organisation.getchisRab()==Name){n++;
                            }
                        i++;
                        }
        
        int[] a=new int[n];
        i=0; n=0;
        while(i<organisations.size()){
                        Organisation organisation = (Organisation) organisations.get(i);
                        if (organisation.getchisRab()==Name){a[n]=i; n++;
                        }
                        i++;
                        }
        return a;
    }
    
    public int[] findgos(String Name){int i=0; int n=0; boolean res;
        while(i<organisations.size()){
                        Organisation organisation = (Organisation) organisations.get(i);
                        if (Name.equals(organisation.getgos())){n++;
                            }
                        i++;
                        }
        
        int[] a=new int[n];
        i=0; n=0;
        while(i<organisations.size()){
                        Organisation organisation = (Organisation) organisations.get(i);
                        if (Name.equals(organisation.getgos())){n++;
                            }
                        i++;
                        }
        return a;
    }
    
   
    public boolean findString(String where, String what)
    {boolean a = false;
        if ((where.length())>=(what.length()))
        {  if (where.substring(0, what.length()).equals(what)) {a=true;
            }
        }
        return a;
    }
    
    
    public String [][] showTabData(){
    String[][] Tab = new String[this.organisations.size()][6];
       for (int i = 0; i < this.organisations.size(); i++) { 
           Tab[i][0]=Integer.toString(i+1);
           Tab[i][1]=this.getProf(i).getType();
           Tab[i][2]=this.getProf(i).getName();
           Tab[i][3]=Integer.toString(this.getProf(i).getchisRab());
           Tab[i][4]=this.getProf(i).getgos();
           Tab[i][5]=this.getProf(i).getField();
       }
    return Tab;    
    }
    
    public String [][] showTabDataFind(int[] a){
    String[][] Tab = new String[a.length][6];
        for (int i = 0; i < a.length; i++){
           Tab[i][0]=Integer.toString(a[i]+1);
           Tab[i][1]=this.getProf(a[i]).getType();
           Tab[i][2]=this.getProf(a[i]).getName();
           Tab[i][3]=Integer.toString(this.getProf(a[i]).getchisRab());
           Tab[i][4]=this.getProf(a[i]).getgos();
           Tab[i][5]=this.getProf(a[i]).getField();
        }
    return Tab;    
    }
  
    public boolean delete(String i){
        int i1=0;
        try {if ((Integer.parseInt(i)>0)&&(Integer.parseInt(i)<=this.organisations.size())) 
        {i1=Integer.parseInt(i);
        this.organisations.remove(i1-1);
        return true;}
        else{return false;}
        }
        catch (NumberFormatException e) {  
        return false;  
        }           
        }   


}
