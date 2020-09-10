import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Credential implements Serializable, Comparable<Credential> {
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

    public ArrayList<String> getBackupCode() {
        return backupCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Credential)) return false;
        Credential that = (Credential) o;
        return Objects.equals(getCredentialName(), that.getCredentialName()) &&
                Objects.equals(getUsername(), that.getUsername()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                getBackupCode().equals(that.getBackupCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCredentialName(), getUsername(), getPassword(), getBackupCode());
    }





    @Override
    public String toString() {
        return "|" + credentialName + '|' +
                "|" + username + '|' +
                "|" + "********" + '|' +
                "|" + backupCode + "|";
    }

    @Override
    public int compareTo(Credential o) {
        return this.credentialName.compareTo(o.credentialName);
    }
}
