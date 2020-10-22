package problem.json;

import java.io.IOException;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.google.gson.Gson;

public class JsonParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testParsing();
	}
	
	public static void testParsing(){
    	String url = "https://jsonmock.hackerrank.com/api/football_matches?year=2011";
    	String urlPage = "https://jsonmock.hackerrank.com/api/football_matches?year=2011&page=";
    	HttpClient client  = new HttpClient();
    	GetMethod req = new GetMethod(url);
        try {
			client.executeMethod(req);
			System.out.println("Status:" + req.getStatusCode());
			String res = req.getResponseBodyAsString();
			System.out.println("Body :" +  res);
			Gson gson =  new Gson();
			ResponseSummary r = gson.fromJson(res, ResponseSummary.class);
			System.out.println("TotalPages:" + r.getTotal_pages());
			int count = 0;
			for(int i = 1; i <= r.getTotal_pages() -1 ;i++){
				GetMethod req1 = new GetMethod(urlPage+i);
				client.executeMethod(req1);
				String res1 = req1.getResponseBodyAsString();
				System.out.println("Body :" +  res1);
				Gson gson1 =  new Gson();
				Response r1 = gson.fromJson(res1, Response.class);
				for(MatchRecord record :  r1.getData()){
					if(record.getTeam1goals().equals(record.getTeam2goals())){
						count++;
					}
				}
			}
			
			System.out.println("Count="+count);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    static class Response{
    	List<MatchRecord> data;
    	int total;
    	int total_pages;
    	public int getTotal_pages() {
			return total_pages;
		}
		public void setTotal_pages(int total_pages) {
			this.total_pages = total_pages;
		}
		public List<MatchRecord> getData(){
    		return this.data;
    	}
    	public int getTotal(){
    		return this.total;
    	}
    	public void setTotal(int total){
    		this.total = total;
    	}
    	public void setData(List<MatchRecord> data){
    		this.data = data;
    	}
    }
    
    
    static class ResponseSummary{
    	int total;
    	int total_pages;
    	public int getTotal_pages() {
			return total_pages;
		}
		public void setTotal_pages(int total_pages) {
			this.total_pages = total_pages;
		}
    	public int getTotal(){
    		return this.total;
    	}
    	public void setTotal(int total){
    		this.total = total;
    	}
    }
    
    static class MatchRecord{
    	String team1goals;
    	String team2goals;
    	public String getTeam1goals(){
    		return this.team1goals;
    	}
    	public String getTeam2goals(){
    		return this.team2goals;
    	}
    	public void setTeam1goals(String team1goals){
    		this.team1goals = team1goals;
    	}
    	public String getTeam2goals(String team2goals){
    		return this.team2goals = team2goals;
    	}
    }
}


