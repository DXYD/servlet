package bean;

/**
 * @author 28182
 */
public class Students {
    private Integer age;
    private boolean sex;
    private String name;

    public Students(String name, boolean sex, int age){
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isSet() {
        return sex;
    }

    public void setSet(boolean sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
