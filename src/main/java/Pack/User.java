package Pack;

public class User {
    private String UID;
    private String UNAME;
    private String PW;
    private String CID;

    public User(String UID, String PW) {
        // TODO Auto-generated constructor stub
        this.UID = UID;
        this.PW = PW;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String uID) {
        UID = uID;
    }

    public String getUNAME() {
        return UNAME;
    }

    public void setUNAME(String uNAME) {
        UNAME = uNAME;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String pW) {
        PW = pW;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String cID) {
        CID = cID;
    }
}
