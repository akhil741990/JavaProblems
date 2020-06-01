package urlshortner;

public class UrlShortner {

	
	static char [] charMap = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	
	public static String generateShortUrl(int id){
		StringBuilder urlBuilder = new StringBuilder();
		int num = id;
		int mod;
		while(num > 0){
			mod = num % 62;
			num = num / 62;
			urlBuilder.append(charMap[mod]);
		}
		return urlBuilder.reverse().toString();
	}
	
	public static void main(String args[]){
		int n = 12345;  
        String shorturl = generateShortUrl(n);  
        System.out.println(shorturl);
        int id = shortUrlToId(shorturl);
        System.out.println("shortUrlToId("+shorturl + ") = "+id);
	}
	
	public static int shortUrlToId(String url){
		int id = 0;
		for(int i = 0 ; i < url.length();i++){
			if(url.charAt(i) >= 'a' && url.charAt(i) <= 'z'){
				id = id * 62 + url.charAt(i) - 'a';
			}else if (url.charAt(i) >= 'A' && url.charAt(i) <= 'Z'){
				id = id * 62 + url.charAt(i) - 'A' + 26;
			}else if (url.charAt(i) >= '0' && url.charAt(i) <= '9'){
				id = id * 62 + url.charAt(i) - '0' + 52;
			}
		}
		return id;
	}
	
}
