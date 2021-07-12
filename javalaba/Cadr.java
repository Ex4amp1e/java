package javalaba4;

import java.io.Serializable;

/**
 *
 * @author Jz
 */
public abstract class Cadr implements Serializable {

    private String fam;
    private int age;
    private boolean eng;
    private String post;
    /*
     * получение данных
     */
    public Cadr(String pst, String fam, int age, boolean eng) {
        this.post = pst;
        this.fam = fam;
        this.age = age;
        this.eng = eng;
    }
    public String getEng() {
        String s;
        if (this.isEng() == true) {
            s = "ДА";
        } else {
            s = "НЕТ";
        }
        return s;
    }

    /**
     * @return the fam
     */
    public String getFam() {
        return fam;
    }

    /**
     * @param fam the fam to set
     */
    public void setFam(String fam) {
        this.fam = fam;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the gend
     */
    public boolean isEng() {
        return eng;
    }

    
    public void setEng(boolean eng) {
        this.eng = eng;
    }

    /**
     * @return the post
     */
    public String getPost() {
        return post;
    }

    /**
     * @param post the post to set
     */
    public void setPost(String post) {
        this.post = post;
    }
    
    abstract String zp ();
}
