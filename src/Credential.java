import java.io.Serializable;
import java.util.ArrayList;

public class Credential implements Serializable {
    private String credentialName;
    private String username, password;
    private ArrayList<String> backupCode = new ArrayList<>();

    public Credential() {

    }

    public Credential(String credentialName, String username, String password, ArrayList<String> backupCode) {
        this.credentialName = credentialName;
        this.username = username;
        this.password = password;
        this.backupCode = backupCode;
    }

    public String getCredentialName() {
        return credentialName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setCredentialName(String credentialName) {
        this.credentialName = credentialName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBackupCode(ArrayList<String> backupCode) {
        this.backupCode = backupCode;
    }

    @Override
    public String toString() {
        String separetor = "________________________________________________";
        String s = "|name credential|username|password|backup codes|";
        return separetor + "\n" +s + "\n" + "|" + credentialName + '|' +
                "|" + username + '|' +
                "|" + password + '|' +
                "|" + backupCode + "|";
    }
}
