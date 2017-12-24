package hebei.engineery.univercity.web.response;

import hebei.engineery.univercity.enums.CommunityResultCode;

import java.util.List;

public class UnivercityResult<T> {
    private CommunityResultCode code;
    private List<T> data;
    private Exception exception;

    public CommunityResultCode getCode() {
        return code;
    }

    public void setCode(CommunityResultCode code) {
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

    public UnivercityResult<T> createData(CommunityResultCode code, List<T> data, Exception exception){
        this.code=code;
        this.data=data;
        this.exception=exception;
        return this;
    }
}
