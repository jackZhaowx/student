package hebei.engineery.univercity.enums;

public enum CommunityResultCode {
    SUCCESS(10000),
    ERROR(10001);
    private Integer code;

    private CommunityResultCode(Integer code) {
        this.code = code;
    }

    private Integer getCode() {
        return code;
    }

    public CommunityResultCode resolve(Integer code) {
        switch (code) {
            case 10000:
                return SUCCESS;
            case 10001:
                return ERROR;
            default:
                return null;
        }
    }

}
