package jsonPlaceholderRequests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class UpdatingResource {
	@Test
    public void UpdateUser() throws IOException {
		
      FileInputStream fis = new FileInputStream("C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Project\\Json.xlsx");
        	
      XSSFWorkbook workbook = new XSSFWorkbook(fis);
      
            XSSFSheet ws = workbook.getSheetAt(0);
            
            int rownum  = ws.getLastRowNum();
            
            int colnum = ws.getRow(1).getPhysicalNumberOfCells();
            
            System.out.println(colnum);
            
            System.out.println(rownum);
            
            XSSFCell uid;
            
            XSSFCell utitle;
            
            XSSFCell ubody;
            
            XSSFCell userid;
            for(int i=1;i<= rownum;i++) {
                
                uid=ws.getRow(i).getCell(0);
                
                userid=ws.getRow(i).getCell(1);
                
                utitle=ws.getRow(i).getCell(2);
                ubody=ws.getRow(i).getCell(3);
                
                RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
                
                System.out.println(uid.toString());
                
                System.out.println(utitle.toString());
                
                System.out.println(ubody.toString());
                
                System.out.println(userid.toString());
                
                RequestSpecification request = RestAssured.given();
                Response response = request.body("{\"id\":\"" + uid +"\",\"title\":\"" +utitle +"\",\"body\":\"" +ubody +"\",\"userId\":\"" +userid +"\"}" ).put("/posts/1");

              
               ResponseBody body = response.getBody();
               
               //
               //Response in raw format
                System.out.println(body.asString());
              //Assert that correct status code is returned
                int statusCode = response.getStatusCode();
                
                Assert.assertEquals(statusCode , 200 , "Successful");
                System.out.println("Status code => " + response.getStatusCode());
                
                //Assert Status line
                String statusLine = response.getStatusLine();
                
                Assert.assertEquals(statusLine , "HTTP/1.1 200 OK" , "Correct status code returned");
                
                System.out.println("Status line => " + response.getStatusLine());
                
}
}

	
}

