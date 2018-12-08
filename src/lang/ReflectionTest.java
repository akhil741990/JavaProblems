package lang;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.security.acl.Permission;



public class ReflectionTest {
	public static void main(String args[]) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		
		setSecurityManager();
		ImmutableClass i = new ImmutableClass("Immutable");
		System.out.println("Old Value :"+i.getName());

		Field f = i.getClass().getDeclaredField("name");
		
		f.setAccessible(true);
		f.set(i, "mutable");
		
		System.out.println("New Value :"+i.getName());
	}
	
	
	 private static void setSecurityManager(){
	    	System.setSecurityManager(new SecurityManager(){
	    		
	    		public void checkPermission(Permission perm){
	    			if(perm.getClass()== ReflectionTest.class && "suppressAccessChecks".equals(((Member) perm).getName())){
	    				throw new SecurityException("can't supress AccessChecks");
	    			}
	    		}
	    	});
	    }
}
