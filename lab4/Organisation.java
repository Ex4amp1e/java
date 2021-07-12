package javalaba4;


public abstract class Organisation {

    private String name;
    private int chisRab;
    private String type;
    private boolean gos;
    /*
     * получение данных
     */
    public Organisation(String type, String name, int chisRab, boolean gos) {
        this.type = type;
        this.name = name;
        this.chisRab = chisRab;
        this.gos = gos;
    }
    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }
    
     public int getchisRab() {
        return this.chisRab;
    }
     
     public String getgos() {
         if (this.gos) return "ДА";
         else return "НЕТ";
     }
     
     public void setgos(boolean gos) {
         this.gos=gos;
     }
    
    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     public void setchisRab(int chisRab) {
        this.chisRab = chisRab;
    }

    public abstract String getField();
}
