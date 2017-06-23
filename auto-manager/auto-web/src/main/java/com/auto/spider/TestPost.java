package com.auto.spider;

import org.apache.log4j.*;  
import java.io.*;  
import java.net.*;  
import java.util.*;  

public class TestPost {    
    
  private static final Logger log = Logger.getLogger(TestPost.class);  
    
  public static void TestPost() throws IOException {    
      /*ProxyInfo proxyInfo = new ProxyInfo(); 
      String proxyIP = proxyInfo.getProxyIP(); 
      int proxyPort = proxyInfo.getProxyPort();*/  
        
      //ReadFile.readFile("");  
        
      ArrayList<ProxyInfo> abc = ReadFile.readFile("D:/ip.txt");  
      URL url = new URL("http://weibo.com/3902408720/F6Z0l3wzz");    
      for(int i = 0; i < 500; i++ ){  
          //Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress("127.0.0.1", 8087));  
          System.getProperty("http.maxRedirects", "50");  
          System.getProperties().setProperty("proxySet", "true");  
          System.out.println("此时的代理服务器设置为" + abc.get(i).getProxyIP()  
                  + "端口号设置为" + abc.get(i).getProxyPort());  
          URLConnection connection = url.openConnection();   
          connection.setRequestProperty(//设置终端类型  
                  "User-Agent",  
                  "Mozilla/4.0 (compatible; MSIE 7.0; NT 5.1; GTB5; .NET CLR 2.0.50727; CIBA)"  
                  );    
          System.getProperties().setProperty("http.proxyHost", abc.get(i).getProxyIP());  
          System.getProperties().setProperty("http.proxyPort", abc.get(i).getProxyPort());  
        
          connection.setDoOutput(true);    
          OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");    
          out.write("id=19&submit="); // 向页面传递数据。post的关键所在！    
          out.flush();    
          out.close();    
          // 一旦发送成功，用以下方法就可以得到服务器的回应：    
          String sCurrentLine;    
          String sTotalString;    
          sCurrentLine = "";    
          sTotalString = "";    
          InputStream l_urlStream;   
          try {
              l_urlStream = connection.getInputStream();  
			} catch (Exception e) {
				continue;
			}
  
          // 传说中的三层包装阿！    
          BufferedReader l_reader = new BufferedReader(new InputStreamReader(    
                  l_urlStream));    
          while ((sCurrentLine = l_reader.readLine()) != null) {    
              sTotalString += sCurrentLine + "\r\n";    
      
          }    
          System.out.println(sTotalString);    
          log.info(getHtml("http://weibo.com/3902408720/F6Z0l3wzz"));    
      }    
  }    
  
  public static void main(String[] args) throws IOException {    
      //System.setProperties("");  
      //System.setProperty("", "");  
      TestPost();    
  }    
  /****************下面是从IP138获取一下是否正确设置了代理服务器**************/  
  private static String getHtml(String address){    
      StringBuffer html = new StringBuffer();    
      String result = null;    
      try{    
          URL url = new URL(address);    
          URLConnection conn = url.openConnection();    
          conn.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 7.0; NT 5.1; GTB5; .NET CLR 2.0.50727; CIBA)");    
          BufferedInputStream in = new BufferedInputStream(conn.getInputStream());    
              
          try{    
              String inputLine;    
              byte[] buf = new byte[4096];    
              int bytesRead = 0;    
              while (bytesRead >= 0) {    
                  inputLine = new String(buf, 0, bytesRead, "ISO-8859-1");    
                  html.append(inputLine);    
                  bytesRead = in.read(buf);    
                  inputLine = null;    
              }    
              buf = null;    
          }finally{    
              in.close();    
              conn = null;    
              url = null;    
          }    
          result = new String(html.toString().trim().getBytes("ISO-8859-1"), "gb2312").toLowerCase();    
              
      }catch (Exception e) {    
          e.printStackTrace();    
          return null;    
      }finally{    
          html = null;                
      }    
      System.out.println(result);  
      return result;    
  }    
}    