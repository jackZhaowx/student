package hebei.engineery.univercity.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;



@ConfigurationProperties(prefix = "mydata")
@Configuration
public class DataConfig {
    private Integer partPageSize;
    private Integer mentPageSize;

    public Integer getPartPageSize() {
        return partPageSize;
    }

    public void setMentPageSize(Integer mentPageSize) {
        this.mentPageSize = mentPageSize;
    }

    public Integer getMentPageSize() {
        return mentPageSize;
    }

    public void setPartPageSize(Integer partPageSize) {
        this.partPageSize = partPageSize;
    }
}
