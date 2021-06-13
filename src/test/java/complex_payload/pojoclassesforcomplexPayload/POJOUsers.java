package complex_payload.pojoclassesforcomplexPayload;

public class POJOUsers {

    public POJOUsers(String firstName, String lastName, int id, int subjectid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.subjectid = subjectid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    private String firstName;
    private String lastName;
    private int id;
    private int subjectid;



}
