package com.auto.spider;

import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.UnsupportedEncodingException;  
import java.util.ArrayList;  
  
public class ReadFile {  
    /** 
     *  读取TXT文件中的代理配置文件 
     *  1、获得文件句柄 
     *  2、 获得的句柄当作一个字节码流，对输入的码流进行读取 
     *  读取到输入流之后，需要读取生成字节流 
     *  逐行输出 
     *  考虑到异常情况 
     * */  
    public static ArrayList<ProxyInfo> readFile(String filePath){  
        String encoding = "UTF-8";  
        File file = new File(filePath);  

        ArrayList<ProxyInfo> infos = new ArrayList<ProxyInfo>();  
        if(file.isFile() && file.exists()){//判断文件是否存在  
            try {  
                InputStreamReader read = new InputStreamReader(  
                        new FileInputStream(file), encoding);//编码格式  
                BufferedReader bufferedReader = new BufferedReader(read);  
                String textLine = null;  
                  
                for(int i = 0; (textLine = bufferedReader.readLine()) != null; i++){  
                    String[] proxyInfo = textLine.split(":");  
                    ProxyInfo proxys = new ProxyInfo();  
                    proxys.setProxyIP(proxyInfo[0]);  
                    proxys.setProxyPort(proxyInfo[1]);  
                    infos.add(proxys);  
                    //System.out.println(((ProxyInfo) infos.get(i)).getProxyIP());  
                    //System.out.println(((ProxyInfo) infos.get(i)).getProxyPort());  
                }  
            } catch (UnsupportedEncodingException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            } catch (FileNotFoundException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            } catch (IOException e){  
                e.printStackTrace();  
            }  
        }else{  
            System.out.println("Can not find the Proxy File");  
        }  
        return infos;  
    }  
    /*public static void main(String[] args){ 
        readFile("D:/proxy.txt"); 
    } */  
}  