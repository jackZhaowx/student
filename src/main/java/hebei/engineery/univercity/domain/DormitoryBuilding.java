package hebei.engineery.univercity.domain;

import javax.persistence.*;

/**
 * 宿舍楼表对应的实体
 */
@Entity
@Table(name = "dormitory_building")
public class DormitoryBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private Integer number;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "demo")
    private String demo;

    @Column(name = "wheel")
    private String wheel;

    @Column(name = "phone")
    private String phone;

    @Column(name = "level")
    private int level;

    @Column(name="parent_name")
    private String parentName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
