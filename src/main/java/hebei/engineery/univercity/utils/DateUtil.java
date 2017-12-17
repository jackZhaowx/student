package hebei.engineery.univercity.utils;

import java.util.Date;

public class DateUtil {
    public static String getDatePoor(Date nowDate) {
        Date endDate = new Date();
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        String result="";
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        if(day>0){
            result+=day + "天";
        }
        // 计算差多少小时
        long hour = diff % nd / nh;
        if(hour>0){
            result+=hour + "小时";
        }
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        if(min>0){
            result+= min + "分钟";
        }else{
            result+="1分钟";
        }
        return  result+"前";
    }
}
