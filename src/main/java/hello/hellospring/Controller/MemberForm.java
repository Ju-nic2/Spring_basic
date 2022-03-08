package hello.hellospring.Controller;

public class MemberForm {
    // input tag의 "name = name" 을 보고 Setter호출 후 넘어온 값 저장됨 .
    // Spring Container가 SetName 호출하여 값 저장해줌.
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
