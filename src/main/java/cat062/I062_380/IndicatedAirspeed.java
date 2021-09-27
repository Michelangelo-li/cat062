package cat062.I062_380;

import lombok.Data;


/**
 * Indicated Airspeed parameter
 * 指示空速参数 该参数与Magnetic Heading磁航向类似，同样可以在管制席位屏幕上直观显示，也可用于系统航迹的计算；
 */
@Data
public class IndicatedAirspeed {

    /**
     * uint:knot, LSB:1
     */
    private int Airspeed;

    public static final int length = 2;

    public IndicatedAirspeed(int[] data, int index) {
        Airspeed = ((data[index] << 8) | data[index + 1]);
    }

    @Override
    public String toString() {
        return Airspeed + "";
    }


}
