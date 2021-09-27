package cat062.I062_380;

import lombok.Data;

/**
 * 侧倾角
 * 该参数可以配合空速（True Airspeed）在自动化系统中进行融汇计算，从而提高航迹精度，为管制人员水平方向上的调度指挥提供更可靠的信息
 */
@Data
public class RollAngle {

    /**
     * uint:°, LSB:0.01
     */
    private double Angle;

    public static final int length = 2;


    public RollAngle(int[] data, int index) {
        Angle = ((short)(data[index] << 8) | data[index + 1]) * 0.01;
    }

    @Override
    public String toString() {
        return Angle + "";
    }


}
