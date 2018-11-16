import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.spi.IIORegistry;
import javax.imageio.spi.ImageReaderSpi;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.List;







import com.whir.fxfk.util.EncryUtil;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
	    String t = "ebbf8b031567d8c2ccc35e46cbc66028f442c0b9412b7d6040e24de9721934bb59515fd7194bc235813344fe41066c91054c34def4e2fa353d042b3e72f73466336f6d6fbdb989d87b10c01218f987d0fb0a72619347c82252ce21f51508f152545ccc522f95da5feb8f3e6448a23654a45299c5ae95ad1472842864e467e29865a75d6366f5720e95af52397031d1de1c6f4e72bf26d27f650684767945fcf5dd34a9dbbe801a9072842864e467e29865a75d6366f5720e4d7cebeba845d5c157320806dd3267ec2ec7a66a49f4264395839939b3c18171609056663d9e6a843ce2a61329cc8c5293cb3794a4f0732fdfb92a1645d44d0c9d432794ae13f7536bcf1ff68c8b96ba571b1ed5a115f5effb0a72619347c82252ce21f51508f152d92a76a75316a7f2e90e6617745a3cb0547e18dea9d70562c6bebb4fbe8a82ed1b5833aaf2cfc3e130cb5c79c3a38ac2bf087b8e2839bf4eeb8f3e6448a23654c3924b19694aac5f351146114503a9ab210416c1717d636be8d9319ef620e75ca53703cc009fd8b668aabc172e53539e9367581c79342c459d432794ae13f753568ee33cdf6337e51b5833aaf2cfc3e130cb5c79c3a38ac2b54e9feb02f72d1beb8f3e6448a2365486b89924808753971b5833aaf2cfc3e130cb5c79c3a38ac2bd448fd8870068e0e90e6617745a3cb0302362bd2be4fdd280302d556b4cb904fb0a72619347c82252ce21f51508f152f05066a695de2416e90e6617745a3cb01bd8d54bc0221c4efb0a72619347c82252ce21f51508f152b9d992e1c426b93f3d042b3e72f73466325af62ec0cb67ac3e58d0db4666a03e894b7c886da463ff813344fe41066c91dabeb1c61b38ed1eeb8f3e6448a23654c3924b19694aac5f351146114503a9ab210416c1717d636be8d9319ef620e75ca53703cc009fd8b668aabc172e53539ec19df4f2ddf706793d042b3e72f73466e3d0439be250b734609056663d9e6a8456f35c09d6a1975c0e5825f1599eea5d579f07f34f21e2e0"; 
	     System.out.println("解密后：" + (t=EncryUtil.decrypt(t,"4568951")));
	     readStringXml(t);
		
		 
		 
		
		 
	}
	public static void readStringXml(String xml) {
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML
            Element rootElt = doc.getRootElement(); // 获取根节点

            Iterator iter = rootElt.elementIterator("ptable"); // 获取根节点下的子节点head
            // 遍历head节点
            while (iter.hasNext()) {
          	 	Element itemEle = (Element) iter.next();
          	 	System.out.println("表名："+itemEle.attributeValue("name"));
          	 	Iterator iter1 = itemEle.elementIterator("field");
          	  while (iter1.hasNext()) {
          		Element itemEle1 = (Element) iter1.next();
          		System.out.println(itemEle1.attributeValue("name")+"-----------------"+itemEle1.getStringValue());
          	  }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	/**
	 * 获取前置机数据
	 * 
	 * @return
	 */
	public static List getFrontendList(String sql) {
		List list = new ArrayList();
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=ezoffice";
		String userName = "ezoffice";
		String userPwd = "13572468";
		Connection dbConn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName,userPwd);
			stmt=dbConn.createStatement();
			rs=stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData() ; 
			int columnCount = rsmd.getColumnCount(); //获取数据总列数
			while(rs.next()){
			   Object[] obj = new Object[columnCount];
			   for(int i=0; i<columnCount; i++){
				   obj[i]=rs.getObject(i+1);
			   }
			   list.add(obj);
			 }
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				dbConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	
	/**
     * ByteArrayOutputStream转换为byte数组
     * @param in
     * @return
     * @throws IOException
     */
    private static byte[] toByteArray(FileInputStream in) throws IOException {
   	 
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }
}
