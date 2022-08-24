package client.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;



public class ProductRestHttpClientApp {
	
	// main Method
	public static void main(String[] args) throws Exception{
		
		////////////////////////////////////////////////////////////////////////////////////////////
		// �ּ��� �ϳ��� ó���ذ��� �ǽ�
		////////////////////////////////////////////////////////////////////////////////////////////
		
//		System.out.println("\n====================================\n");
//		// 1.1 Http Get ��� Request : JsonSimple lib ���
//		ProductRestHttpClientApp.getProductTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 1.2 Http Get ��� Request : CodeHaus lib ���
//		ProductRestHttpClientApp.getProductTest_Codehaus();
		
//		System.out.println("\n====================================\n");
//		// 2.1 Http Post ��� Request : JsonSimple lib ���
//		ProductRestHttpClientApp.addProductTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 1.2 Http Post ��� Request : CodeHaus lib ���
//		ProductRestHttpClientApp.addProductTest_Codehaus();	

//		System.out.println("\n====================================\n");
//		// 2.1 Http Post ��� Request : JsonSimple lib ���
//		ProductRestHttpClientApp.updateProductPostTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 1.2 Http Post ��� Request : CodeHaus lib ���
//		ProductRestHttpClientApp.updateProductPostTest_Codehaus();	
		
//		System.out.println("\n====================================\n");
//		// 2.1 Http Post ��� Request : JsonSimple lib ���
//		ProductRestHttpClientApp.listProductTest_JsonSimple();
		
		System.out.println("\n====================================\n");
		// 1.2 Http Post ��� Request : CodeHaus lib ���
		ProductRestHttpClientApp.listProductTest_Codehaus();	
		
	
	}
	
	
//================================================================//
	//1.1 Http Protocol GET Request : JsonSimple 3rd party lib ���
	public static void getProductTest_JsonSimple() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url= 	"http://127.0.0.1:8080/product/json/getProduct/10000";
				
		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		//==> �����б�(JSON Value Ȯ��)
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
	}
	
	
	//1.2 Http Protocol GET Request : JsonSimple + codehaus 3rd party lib ���
	public static void getProductTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url= 	"http://127.0.0.1:8080/product/json/getProduct/10000";

		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> �ٸ� ������� serverData ó�� 
		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		//==> API Ȯ�� : Stream ��ü�� ���� ���� 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	
		//ObjectMapper objectMapper = new ObjectMapper();
		// Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		 //System.out.println(product);
	}
//================================================================//	
	
//================================================================//
		//2.1 Http Protocol POST Request : FromData ���� / JsonSimple 3rd party lib ���
		public static void addProductTest_JsonSimple() throws Exception{
			
			// HttpClient : Http Protocol �� client �߻�ȭ 
			HttpClient httpClient = new DefaultHttpClient();
			
			String url = "http://127.0.0.1:8080/product/json/addProduct";
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-Type", "application/json");
			
			//[ ��� 1 : String ���]
//				String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//				HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
			
			//[ ��� 2 : JSONObject ���]
			JSONObject json = new JSONObject();
			json.put("prodName", "����");
			json.put("price", "2000");
			json.put("prodDetail", "�������� ��");
			
//			Map<String, String>  map = new HashMap<String, String>();
//			map.put("prodName", "����");
//			map.put("price", "2000");
//			map.put("prodDetail", "�������� ��");
			
			HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");

			httpPost.setEntity(httpEntity01);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			
			//==> Response Ȯ��
			System.out.println(httpResponse);
			System.out.println();

			//==> Response �� entity(DATA) Ȯ��
			HttpEntity httpEntity = httpResponse.getEntity();
			
			//==> InputStream ����
			InputStream is = httpEntity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			
			System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
			String serverData = br.readLine();
			System.out.println(serverData);
			
			//==> �����б�(JSON Value Ȯ��)
			JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
			System.out.println(jsonobj);
		
		}
		
		
		//2.2 Http Protocol POST ��� Request : FromData���� 
		//==> JsonSimple + codehaus 3rd party lib ���
		public static void addProductTest_Codehaus() throws Exception{
			
			// HttpClient : Http Protocol �� client �߻�ȭ 
			HttpClient httpClient = new DefaultHttpClient();
			
			String url = "http://127.0.0.1:8080/product/json/addProduct";
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-Type", "application/json");
			
//			//[ ��� 1 : String ���]
//			String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//			HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
		
//			//[ ��� 2 : JSONObject ���]
//			JSONObject json = new JSONObject();
//			json.put("userId", "admin");
//			json.put("password", "1234");
//			HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
			
			//[ ��� 3 : codehaus ���]
			Product prod =  new Product();
			prod.setProdName("���");
			prod.setPrice(7000);
			prod.setProdDetail("�ٻ�� �İ��� ���ƿ�");
			ObjectMapper objectMapper01 = new ObjectMapper();
			//Object ==> JSON Value �� ��ȯ
			String jsonValue = objectMapper01.writeValueAsString(prod);
			
			System.out.println(jsonValue);
			
			HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
			
			httpPost.setEntity(httpEntity01);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			
			//==> Response Ȯ��
			System.out.println(httpResponse);
			System.out.println();

			//==> Response �� entity(DATA) Ȯ��
			HttpEntity httpEntity = httpResponse.getEntity();
			
			//==> InputStream ����
			InputStream is = httpEntity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			
			//==> �ٸ� ������� serverData ó�� 
//			System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
//			String serverData = br.readLine();
//			System.out.println(serverData);
			
			//==> API Ȯ�� : Stream ��ü�� ���� ���� 
			JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
			System.out.println(jsonobj);
		
			ObjectMapper objectMapper = new ObjectMapper();
			 Map<String, Object> map = objectMapper.readValue(jsonobj.toString(), new TypeReference<Map<String, Object>>() {});
			 System.out.println(map.get("product"));
		}	
		
	//================================================================//	
		
	//================================================================//
		//2.1 Http Protocol POST Request : FromData ���� / JsonSimple 3rd party lib ���
		public static void updateProductPostTest_JsonSimple() throws Exception{
			
			// HttpClient : Http Protocol �� client �߻�ȭ 
			HttpClient httpClient = new DefaultHttpClient();
			
			String url = "http://127.0.0.1:8080/product/json/updateProduct";
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-Type", "application/json");
			
			//[ ��� 1 : String ���]
//				String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//				HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
			
			//[ ��� 2 : JSONObject ���]
			JSONObject json = new JSONObject();
			json.put("prodNo", "10037");
			json.put("prodName", "�����ո���");
			json.put("prodDetail", "���μ��� ��!");
			HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");

			httpPost.setEntity(httpEntity01);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			
			//==> Response Ȯ��
			System.out.println(httpResponse);
			System.out.println();

			//==> Response �� entity(DATA) Ȯ��
			HttpEntity httpEntity = httpResponse.getEntity();
			
			//==> InputStream ����
			InputStream is = httpEntity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			
			System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
			String serverData = br.readLine();
			System.out.println(serverData);
			
			//==> �����б�(JSON Value Ȯ��)
			JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
			System.out.println(jsonobj);
		
		}
		
		//2.2 Http Protocol POST ��� Request : FromData���� 
		//==> JsonSimple + codehaus 3rd party lib ���
		public static void updateProductPostTest_Codehaus() throws Exception{
			
			// HttpClient : Http Protocol �� client �߻�ȭ 
			HttpClient httpClient = new DefaultHttpClient();
			
			String url = "http://127.0.0.1:8080/product/json/updateProduct";
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-Type", "application/json");
			
//			//[ ��� 1 : String ���]
//			String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//			HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
		
//			//[ ��� 2 : JSONObject ���]
//			JSONObject json = new JSONObject();
//			json.put("userId", "admin");
//			json.put("password", "1234");
//			HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
			
			//[ ��� 3 : codehaus ���]
			Product user01 =  new Product();
			user01.setProdNo(10038);
			user01.setProdName("�Ҵߺ�����");
			user01.setProdDetail("��Ÿ���� �ſ� ��");
			ObjectMapper objectMapper01 = new ObjectMapper();
			//Object ==> JSON Value �� ��ȯ
			String jsonValue = objectMapper01.writeValueAsString(user01);
			
			System.out.println(jsonValue);
			
			HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
			
			httpPost.setEntity(httpEntity01);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			
			//==> Response Ȯ��
			System.out.println(httpResponse);
			System.out.println();

			//==> Response �� entity(DATA) Ȯ��
			HttpEntity httpEntity = httpResponse.getEntity();
			
			//==> InputStream ����
			InputStream is = httpEntity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			
			//==> �ٸ� ������� serverData ó�� 
			//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
			//String serverData = br.readLine();
			//System.out.println(serverData);
			
			//==> API Ȯ�� : Stream ��ü�� ���� ���� 
			JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
			System.out.println(jsonobj);
		
			ObjectMapper objectMapper = new ObjectMapper();
			 Map<String, Object> user = objectMapper.readValue(jsonobj.toString(), new TypeReference<Map<String, Object>>() {});
			 System.out.println(user.get("updateProduct"));
		}	
		
		//================================================================//	
		
		//================================================================//
		//2.1 Http Protocol POST Request : FromData ���� / JsonSimple 3rd party lib ���
		public static void listProductTest_JsonSimple() throws Exception{
			
			// HttpClient : Http Protocol �� client �߻�ȭ 
			HttpClient httpClient = new DefaultHttpClient();
			
			String url = "http://127.0.0.1:8080/product/json/listProduct";
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-Type", "application/json");
			
			//[ ��� 1 : String ���]
//				String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//				HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
			
			//[ ��� 2 : JSONObject ���]
			JSONObject json = new JSONObject();
//			json.put("prodNo", "10037");
//			json.put("prodName", "�����ո���");
//			json.put("prodDetail", "���μ��� ��!");
			HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
			
			httpPost.setEntity(httpEntity01);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			
			//==> Response Ȯ��
			System.out.println(httpResponse);
			System.out.println();
			
			//==> Response �� entity(DATA) Ȯ��
			HttpEntity httpEntity = httpResponse.getEntity();
			
			//==> InputStream ����
			InputStream is = httpEntity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			
			System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
			String serverData = br.readLine();
			System.out.println(serverData);
			
			//==> �����б�(JSON Value Ȯ��)
			JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
			System.out.println(jsonobj);
			
		}
		
		
		//2.2 Http Protocol POST ��� Request : FromData���� 
		//==> JsonSimple + codehaus 3rd party lib ���
		public static void listProductTest_Codehaus() throws Exception{
			
			// HttpClient : Http Protocol �� client �߻�ȭ 
			HttpClient httpClient = new DefaultHttpClient();
			
			String url = "http://127.0.0.1:8080/product/json/listProduct";
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-Type", "application/json");
			
//			//[ ��� 1 : String ���]
//			String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//			HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
			
//			//[ ��� 2 : JSONObject ���]
//			JSONObject json = new JSONObject();
//			json.put("userId", "admin");
//			json.put("password", "1234");
//			HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
			
			//[ ��� 3 : codehaus ���]
			Product user01 =  new Product();
//			user01.setProdNo(10038);
//			user01.setProdName("�Ҵߺ�����");
//			user01.setProdDetail("��Ÿ���� �ſ� ��");
			ObjectMapper objectMapper01 = new ObjectMapper();
			//Object ==> JSON Value �� ��ȯ
			String jsonValue = objectMapper01.writeValueAsString(user01);
			
			System.out.println(jsonValue);
			
			HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
			
			httpPost.setEntity(httpEntity01);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			
			//==> Response Ȯ��
			System.out.println(httpResponse);
			System.out.println();
			
			//==> Response �� entity(DATA) Ȯ��
			HttpEntity httpEntity = httpResponse.getEntity();
			
			//==> InputStream ����
			InputStream is = httpEntity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			
			//==> �ٸ� ������� serverData ó�� 
			//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
			//String serverData = br.readLine();
			//System.out.println(serverData);
			
			//==> API Ȯ�� : Stream ��ü�� ���� ���� 
			JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
			System.out.println(jsonobj);
			
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> user = objectMapper.readValue(jsonobj.toString(), new TypeReference<Map<String, Object>>() {});
			System.out.println(user.get("list"));
			System.out.println(user.get("search"));
			System.out.println(user.get("resultPage"));
		}	
}