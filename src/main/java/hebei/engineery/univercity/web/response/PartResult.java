package hebei.engineery.univercity.web.response;

import hebei.engineery.univercity.enums.PartResultCode;

import java.util.List;

public class PartResult<T> {
    private PartResultCode code;
    private List<T> data;
    private Exception exception;

    public PartResultCode getCode() {
        return code;
    }

    public void setCode(PartResultCode code) {
        this.code = code;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public  PartResult<T> createData(PartResultCode code, List<T> data, Exception exception){
        this.code=code;
        this.data=data;
        this.exception=exception;
        return this;
    }
}
