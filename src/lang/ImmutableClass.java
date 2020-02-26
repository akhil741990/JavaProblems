package lang;

import java.security.acl.Permission;

public class ImmutableClass {

	
private final String name;
    
    public ImmutableClass(String name) {
        this.name = name;
    }
    
    public synchronized String getName() {
        return name;
    }
    
}
