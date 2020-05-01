package Model;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nameuser")
    private String name = null;
    @Column(name = "age")
    private Long age = null;
    User(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public static class Builder{
        private static User newUser;
        public Builder(){
            newUser = new User();
        }

        public Builder withId(Long id){
            newUser.id = id;
            return this;
        }

        public Builder withName(String name){
            newUser.name = name;
            return this;
        }
        public Builder withAge(Long age){
            newUser.age = age;
            return this;
        }
        public User build(){
            return newUser;
        }
    }
}
