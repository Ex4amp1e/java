package javalaba4;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Jz
 */

/*
 * Ввод строки
 * Ввод числа
 */
public class InOut {
    
public InOut() 
    {
    }

public String inStr()  
    {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //ввод с устр. по умолчанию
    String iS;
    try{
        iS = br.readLine();              
        }
    catch(Exception e){
        iS="";
        System.out.println("Считать не удалось");
        }
    return iS;      
    }
    
    /**
     * 
     * @return
     * @throws Exception 
     */
public int inInt()   
    {
    int resInt=0; boolean chkN=false; 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String iS;
    while (chkN==false) 
        {
        try{
            iS = br.readLine();   
            }
        catch(Exception e){
            iS = "";
            System.out.println("Считать не удалось");
            }
        try                        
            {
            resInt = Integer.parseInt(iS); 
            chkN=true;                 //да, это число
            }
        catch(Exception e)          
            {System.out.println("Это не число. Повторите.\n");} //еще раз
        }
    return resInt;
    }
    

public boolean inBool()  
    {
    int resInt=2; boolean resBool=false; 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String iS;
    while (resInt<0 || resInt>1) 
        {
        try{
            iS = br.readLine();   
            }
        catch(Exception e){
            iS = "";
            System.out.println("Считать не удалось");
            }
        try                       
            {
            resInt = Integer.parseInt(iS); 
            if (resInt==1){resBool=true;}
            if (resInt==0){resBool=false;}
            }
        catch(Exception e)         
            {System.out.println("Это не 1 и не 0. Повторите.\n");} 
        }
    return resBool;
    }

/**
 * Сохранение в файл ArrayList'а
 * @param name Имя файла
 * @param arL задаваемый ArrayList
 * @throws IOException 
 */
public static void saveArrlistAsObj(String name, ArrayList arL)
    {
    if (arL.isEmpty()) {System.out.println("Список пуст. Сохранять нечего.");}
    else{
        try{
            FileOutputStream fos = new FileOutputStream(name);
            ObjectOutputStream out = new ObjectOutputStream(fos);        
            try {
                out.writeObject(arL);
                }
            catch (IOException e)
                {
                try {out.close();}                   
                catch (Exception e1) {};
                System.out.println("Не сохранено.");
                e.printStackTrace();
                return;
                }
            out.close();
            System.out.println("Успешно сохранено.");
            }
        catch(IOException e){
            System.out.println("Не удалось запустить сохранение.");
            }
        }
        
    }

/**
 * Загрузка с файла ArrayList'а
 * @param name Имя файла
 * @return ArrayList
 * @throws Exception 
 */
public static ArrayList loadArrlistAsObj(String name)
    {
    ArrayList arL = new ArrayList();    
    try{
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream in = new ObjectInputStream(fis);
        arL = (ArrayList)in.readObject();
        in.close();
        System.out.println("Успешно загружено.");
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден.");
        } catch (IOException ex) {
            System.out.println("Не удалось загрузить файл.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Класс ArrayList не описан. Загрузка невозможна.");
        }
    return arL;
    }

/**
 * True при наождении последовательности символов из WHAT во WHERE
 * @param where строка-источник
 * @param what искомая строка
     * @return 
 */
public boolean findString(String where, String what)
    {int j = 0;
     boolean a = false;
        while (j < (where.length() - what.length())) {
            if (where.substring(j, j + what.length()).equalsIgnoreCase(what)) {a=true;
            }
            j++;}
        return a;
    }


//!!!!Методы, не использующиеся в этой программе:

    /**
     * Считывание файла в строку
     * @param file переменная
     * @param encoding имя кодировки
     * @return
     * @throws IOException 
     */
public static String loadFileAsString(File file, String encoding) throws IOException
    {
    InputStreamReader fl = encoding==null ? 
    new FileReader(file):                  
    new InputStreamReader(new FileInputStream(file),encoding); 
 
    StringBuffer sb= new StringBuffer();       
 
    try {
        char[] buf= new char[32768];            
        int len;                                
        while ((len=fl.read(buf,0,buf.length))>=0) //циклируем
            {
            sb.append(buf,0,len);                 
            }
        return sb.toString();                    
        } 
    finally {                                    
          try {fl.close();} catch (Exception e) {};
            }
    }
    
/**
 * Сохрнение в строку
 * @param fileName "имя файла"
 * @param encoding кодировка (не обязательно)
 * @param strSave указываемая строка
 * @throws IOException 
 */    
public static void saveFileFromString(String fileName, String encoding, String strSave) throws IOException
    {
    saveFileFromString(new File(fileName),encoding,strSave);
    }
/**
 * Сохранение в строку
 * @param file файловая переменная
 * @param encoding кодировка
 * @param strSave указываема строка
 * @throws IOException 
 */    
public static void saveFileFromString(File file, String encoding, String strSave) throws IOException
    {
    if (strSave==null)
        {
        file.delete(); 
        return;
        }
    char[] buf= new char[strSave.length()]; 
    strSave.getChars(0,buf.length,buf,0); 
    saveFileFromChars(file,encoding,buf);
    }
    
/**
 * Сохранение как массив символов (сначала и с именем файла)
 * @param fileName "имя файла"
 * @param encoding имя кодировки
 * @param buf массив символов
 * @throws IOException 
 */
public static void saveFileFromChars(String fileName, String encoding,char[] buf)throws IOException
    {
    saveFileFromChars(new File(fileName),encoding,buf);
    }
    
/**
 * Сохранение как массив символов (с самого начала)
 * @param file
 * @param encoding
 * @param buf
 * @throws IOException 
 */
public static void saveFileFromChars(File file, String encoding, char[] buf) throws IOException
    {
    if (buf==null)
        {
        file.delete(); 
        return;
        }
    saveFileFromChars(file,encoding,buf,0,buf.length);
    }
    
/**
 * Сохранение в файл как массив символов (Родитель)
 * @param file переменная файла
 * @param encoding кодировка
 * @param buf масс симвл
 * @param off Смещение, из которого можно начать писать символы
 * @param len длина
 * @throws IOException 
 */
public static void saveFileFromChars(File file, String encoding,char[] buf, int off, int len)
    throws IOException
    {
    if (buf==null)         //если массив слов пуст
        {
        file.delete();     //удаляем файл 
        return;
        }
    OutputStreamWriter fl=null;
      try {
    fl = encoding==null ?   //если кодировка отсутствует,
    new FileWriter(file):                                        //то создаем объект записи на основе объекта File 
    new OutputStreamWriter(new FileOutputStream(file),encoding); //иначе Создаем OutputStreamWriter, который использует именованный набор символов. (ASCII UTF и тд)
  
        fl.write(buf,off,len); 
        System.out.println("Сохранено в ..\\" + file.getName());//записываем часть массива символов в buf
        } 
    catch (IOException e)                 //иначе Пытаемся закрыть поток
        {
        try {
            System.out.println("Произошла ошибка. Пытаемся закрыть файл");
            fl.close();
            System.out.println("Успешно");
        }                   //закрытие потока (не факт)
        catch (Exception e1) {
            System.out.println("Не удалось закрыть");
        }
        }
   // fl.close();          //закрытие потока, если произошла запись.
    }

}
