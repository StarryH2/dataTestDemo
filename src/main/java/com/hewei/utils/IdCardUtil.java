package com.hewei.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author HeWei
 * @Date: 2021/08/05/15:09
 * @Description:
 */
public class IdCardUtil {

    public static String getIdCard(){
        Random random = new Random();
        //出生日期
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
        int startYear=1960;//指定随机日期开始年份
        int endYear=2004;//指定随机日期开始年份(含)
        long start = Timestamp.valueOf(startYear+1+"-1-1 0:0:0").getTime();
        long end = Timestamp.valueOf(endYear+"-1-1 0:0:0").getTime();
        long ms=(long) ((end-start)*Math.random()+start);	//获得了符合条件的13位数
        Date hireday=new Date(ms);
        String hiredayStr = sdfDate.format(hireday);
        String randomStr = "";
        for (int i=0; i<4; i++){
            randomStr += random.nextInt(9);
        }
        return "533001"+hiredayStr+randomStr;
    }
}
