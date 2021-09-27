package cat062.I062_380;

import lombok.Data;

/**
 * 转向角
 * 该参数可以配合地速（Ground Speed）数据在自动化系统中进行融汇计算，
 * 在航迹初始化阶段提高航迹精度，特别是雷达覆盖边缘处的航迹初始化
 */
@Data
public class TrackAngle {

    /**
     * uint:°, LSB:360/2**16
     */
    private double Angle;

    public static final int length = 2;

    //toShort
    public TrackAngle(int[] data, int index) {
        Angle = ((short)(data[index] << 8) | data[index + 1]) * 360.0 / 65536.0;
    }

    @Override
    public String toString() {
        return Angle + "";
    }


}
