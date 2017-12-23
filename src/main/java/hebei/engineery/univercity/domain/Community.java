package hebei.engineery.univercity.domain;

import sun.java2d.loops.GeneralRenderer;

import javax.persistence.*;

@Entity
@Table(name="community")
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "com_name")
    private String comName;

    @Column(name="long_at")
    private String longAt;

    @Column(name="lat_at")
    private String latAt;

    @Column(name = "demo")
    private String demo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getLongAt() {
        return longAt;
    }

    public void setLongAt(String longAt) {
        this.longAt = longAt;
    }

    public String getLatAt() {
        return latAt;
    }

    public void setLatAt(String latAt) {
        this.latAt = latAt;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }
}
