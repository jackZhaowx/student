package hebei.engineery.univercity.enums;

public enum PartResultCode {
    SUCCESS(10000),
    ERROR(10001);
    private Integer code;

    private PartResultCode(Integer code) {
        this.code = code;
    }

    private Integer getCode() {
        return code;
    }

    public PartResultCode resolve(Integer code) {
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
