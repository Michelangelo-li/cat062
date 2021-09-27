package cat062.I062_380;

import lombok.Data;

/**
 * Barometric Pressure Setting 气压表压强设置
 *
 * 该参数为飞机上设置的大气压力值，可以用来与管制已有的参数进行比对，特别是在进近终端区域时，
 * 该参数可以和Selected Altitude参数一起可以为高度冲突提供早期预警；
 */
@Data
public class BarometricPressureSetting {

    /**
     * uint:mb(1毫巴=1百帕), LSB:0.1
     */
    private double Setting;

    public static final int length = 2;

    public BarometricPressureSetting(int[] data, int index) {

        Setting = ((data[index] << 8) | data[index + 1]) * 0.1;
    }

    @Override
    public String toString() {
        return Setting + "";
    }


}
