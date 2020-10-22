package problem.json;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class JsonStreamParser {

	public static void main(String[] args) {
		Gson gson = new Gson();
		// TODO Auto-generated method stub
			try{
				HttpURLConnection connection = (HttpURLConnection) new URL("https://jsonmock.hackerrank.com/api/football_matches?year=2011").openConnection();
				InputStream is = connection.getInputStream();
				JsonReader reader = new JsonReader(new InputStreamReader(is, "UTF-8"));
				List<MatchRecord> records = new ArrayList<MatchRecord>();
		        reader.beginArray();
		        while(reader.hasNext()){
		        	MatchRecord r = gson.fromJson(reader, MatchRecord.class);
		        	records.add(r);
		        	System.out.println("Team1:"+r.getTeam1goals() + " Team2 :"+r.getTeam2goals());
		        }
		        
			}catch(Exception e){
				e.printStackTrace();
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
