package complex_payload.pojoclassesforcomplexPayload;


public class POJOMain {

    public POJOMain(POJOUsers users, POJOMobile mobile, POJOSubject subject) {
        this.users = users;
        this.mobile = mobile;
        this.subject = subject;
    }

    POJOUsers users;
    POJOMobile mobile;
    POJOSubject subject;

    public POJOUsers getUsers() {
        return users;
    }

    public void setUsers(POJOUsers users) {
        this.users = users;
    }

    public POJOMobile getMobile() {
        return mobile;
    }

    public void setMobile(POJOMobile mobile) {
        this.mobile = mobile;
    }

    public POJOSubject getSubject() {
        return subject;
    }

    public void setSubject(POJOSubject subject) {
        this.subject = subject;
    }


}
