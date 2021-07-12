package javalaba4;
import java.util.ArrayList;

/**
 *
 * @author Jz
 */
public class Group {
    
    public ArrayList people = new ArrayList(); //массив записей (по идее)
   
    public void addRab (String Fam,int Age, boolean Eng, int Kof) {
           this.people.add(new Rab (Fam, Age,Eng,Kof));
    }
   
    public void addInj (String Fam,int Age, boolean Eng, int Kof) {
           this.people.add(new Inj (Fam, Age,Eng,Kof));
    }
      
    public void addAdmin (String Fam,int Age, boolean Eng, int Kof) {
           this.people.add(new Admin (Fam, Age,Eng,Kof));
    }
    
    public Cadr getProf(int i){
        return (Cadr) this.people.get(i);
    }
    
   public int[] findFam(String Name){
        int i=0; int n=0; 
        while(i<people.size()){
                        Cadr human = (Cadr) people.get(i);
                        boolean d;
                        d=findString(human.getFam(), Name);
                        if (d){n++;
                            }
                        i++;
                        }
        
        int[] a=new int[n];
        i=0; n=0;
        while(i<people.size()){
                        Cadr human = (Cadr) people.get(i);
                        boolean d;
                        d=findString(human.getFam(), Name);
                        if (d){a[n]=i; n++;
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
   
   public int[] findPro(String Name){
    InOut obj = new InOut();
    
        int i=0; int n=0; 
        while(i<people.size()){
                        Cadr human = (Cadr) people.get(i);
                        if (human.getPost().equals(Name)){n++;
                            }
                        i++;
                        }
        
        int[] a=new int[n];
        i=0; n=0;
        while(i<people.size()){
                        Cadr human = (Cadr) people.get(i);
                        if (human.getPost().equals(Name)){a[n]=i; n++;
                        }
                        i++;
                        }
        return a;
    }
    
   public int[] findEng(String Name){
    
        int i=0; int n=0; 
        while(i<people.size()){
                        Cadr human = (Cadr) people.get(i);
                        if (Name.equals(human.getEng())){n++;
                            }
                        i++;
                        }
        
        int[] a=new int[n];
        i=0; n=0;
        while(i<people.size()){
                        Cadr human = (Cadr) people.get(i);
                        if (human.getEng().equals(Name)){a[n]=i; n++;
                        }
                        i++;
                        }
        return a;
    }
    
   public int[] findAge(int Name){int i=0; int n=0; 
        while(i<people.size()){
                        Cadr human = (Cadr) people.get(i);
                        if (human.getAge()==Name){n++;
                            }
                        i++;
                        }
        
        int[] a=new int[n];
        i=0; n=0;
        while(i<people.size()){
                        Cadr human = (Cadr) people.get(i);
                        if (human.getAge()==Name){a[n]=i; n++;
                        }
                        i++;
                        }
        return a;
    }
    
    public String [][] showTabData(){
    String[][] Tab = new String[this.people.size()][6];
       for (int i = 0; i < this.people.size(); i++) {
           Tab[i][0]=Integer.toString(i+1);
           Tab[i][1]=this.getProf(i).getFam();
           Tab[i][2]=this.getProf(i).getPost();
           Tab[i][3]=Integer.toString(this.getProf(i).getAge());
           Tab[i][4]=this.getProf(i).getEng();
           Tab[i][5]=this.getProf(i).zp();
       }     
    return Tab;    
    }
    public String [][] showTabDataFind(int[] a){
    String[][] Tab = new String[a.length][6];
        for (int i = 0; i < a.length; i++){
           Tab[i][0]=Integer.toString(a[i]+1);
           Tab[i][1]=this.getProf(a[i]).getFam();
           Tab[i][2]=this.getProf(a[i]).getPost();
           Tab[i][3]=Integer.toString(this.getProf(a[i]).getAge());
           Tab[i][4]=this.getProf(a[i]).getEng();
           Tab[i][5]=this.getProf(a[i]).zp();
        }
    return Tab;    
    }
    public boolean delete(String i){
        int i1;
        try {if ((Integer.parseInt(i)>0)&&(Integer.parseInt(i)<=this.people.size())) 
        {i1=Integer.parseInt(i);
        this.people.remove(i1-1);
        return true;}
        else{return false;}
        }
        catch (NumberFormatException e) {  
        return false;  
        }           
        }   


}
