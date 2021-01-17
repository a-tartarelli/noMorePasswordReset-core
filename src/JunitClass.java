import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JunitClass {

    @Test
    public void createCredential() {
        ArrayList<String> backupCode = new ArrayList<String>();
        backupCode.add("125ds4");
        backupCode.add("sd4f5f");
        Credential c = new Credential("test", "mario", "123", backupCode);
        assertEquals("test", c.getCredentialName());
        assertEquals("mario", c.getUsername());
        assertEquals("123", c.getPassword());
        assertEquals(backupCode, c.getBackupCode());
        //System.out.println(c.toString());
    }


    @Test
    public void writeObject() {
        ArrayList<String> backupCode = new ArrayList<String>();
        backupCode.add("125ds4");
        backupCode.add("sd4f5f");
        Credential c = new Credential("test", "mario", "123", backupCode);

        boolean ok = IOfile.WriteObjectToFile(c);
        assertEquals(true, ok);
    }



    @Test
    public void readObject() {
        ArrayList<String> backupCode = new ArrayList<String>();
        backupCode.add("125ds4");
        backupCode.add("sd4f5f");
        Credential c1 = new Credential("test", "mario", "123", backupCode);

        Credential c = (Credential) IOfile.ReadObjectFromFile();
        System.out.println(c.toString());
        boolean equals = c1.equals(c);
        assertTrue(equals);
    }
}
