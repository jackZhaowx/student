package hebei.engineery.univercity.domain;

import javax.persistence.*;

/**
 * 宿舍表对应的实体
 */
@Entity
@Table(name = "dormitory")
public class Dormitory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private long parentId;

    @Column(name = "number")
    private Integer number;

    @Column(name = "level")
    private Integer level;

    @Column(name = "parent_name")
    private String parentName;

    @Column(name = "wheel")
    private String wheel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }
}
