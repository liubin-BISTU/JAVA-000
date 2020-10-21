package com.travelsky.binliu;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;


public class SecondTask  extends ClassLoader{

    
    public static void main(String[] args){
        
        try {
            Class clasz = new SecondTask().findClass("Hello");
            Method helloMethod = clasz.getMethod("hello");
            helloMethod.invoke(clasz.newInstance());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
    
    protected Class<?> findClass(String name){
        
        InputStream iStream = SecondTask.class.getClassLoader().getResourceAsStream("Hello.xlass");
        
        byte[] bytes = null;
        try {
            bytes= new byte[iStream.available()];
            
            iStream.read(bytes);
            
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] =(byte) (255-bytes[i]);
            }
            
            
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }finally{
            try {
                iStream.close();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        
        
        
        return defineClass(name, bytes, 0, bytes.length);
        
    }
}
