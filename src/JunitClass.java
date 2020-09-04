import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JunitClass {

    @Test
    public void createCredential() {
        ArrayList<String> backupCode = new ArrayList<String>();
        backupCode.add("125ds4");
        backupCode.add("sd4f5f");
        Credential c = new Credential("test", "mario", "123", backupCode);
        assertNotNull(c);
        System.out.println(c.toString());
    }
}
