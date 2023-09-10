package pojo;

import com.fasterxml.jackson.annotation.*;

public class Spartan {
    private int id;
    private String name;
    private String gender;
    private Long phone;

    public Spartan(@JsonProperty("id") int id,@JsonProperty("name") String name
            ,@JsonProperty("gender") String gender,@JsonProperty("phone") Long phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }
    public Spartan(@JsonProperty("name") String name,@JsonProperty("gender") String gender,@JsonProperty("phone") Long phone) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }
    public Spartan(){};

    @Override
    public String toString() {
        return "Spartan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Long getPhone() {
        return phone;
    }
}
