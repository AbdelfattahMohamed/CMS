package course;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdelfattah
 */
public class fileManager implements Serializable{
      private static final long serialVersionUID = 5950356113547206315L;
      //-----------------------------------------
      //Write
      //-----------------------------------------
      
    public boolean write(String filePath,Object data){
    try{
        System.out.print("written"+filePath);
        ObjectOutputStream writter=new ObjectOutputStream(new FileOutputStream(filePath));
        writter.writeObject(data);
        System.out.println("done");
        writter.close();
        return true;
    }
    catch(IOException e){
        System.out.println(e);
    }
    return false;
    }
    public Object read(String filePath){
        exist(filePath);
        Object result=null;
        ObjectInputStream reader=null;
        try {
            reader =new ObjectInputStream(new FileInputStream(filePath));
            result=reader.readObject(); 
        } 
        catch (IOException e) {
            System.out.println(e);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(fileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }   
    // Method ARRAYLIST for get filepath
    private  void exist(String filePath) {
		File emp=new File(filePath);
    	if(!emp.exists()) {
			ArrayList l=new ArrayList();
    		write(filePath,l);
    	}
    }    
}
