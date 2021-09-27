package cat062.I062_390;

import lombok.Data;

/**
 * 综合初始飞行计划处理系统
 * Integrated Initial Flight Plan Processing System
 */
@Data
public class IFPS_FLIGHT_ID {

    private int TYP;

    private int Number;

    public static final int length = 4;

    public IFPS_FLIGHT_ID(int[] data, int index) {

        int b32 =  (data[index] << 24) | (data[index + 1] << 16) | (data[index + 2] << 8) | data[index + 3];
        TYP  = (b32 >> 30) & 0x03;
        Number = b32 & 0x07FFFFFF;
    }


    @Override
    public String toString() {
        return  Number + "|" + TYP;
    }


}
