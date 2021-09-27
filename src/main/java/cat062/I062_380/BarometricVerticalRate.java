package cat062.I062_380;

import lombok.Data;

/**
 * 气压垂直速率
 * 该参数包括两个参数，分别是气压高度速率（Barometric Altitude Rate）
 * 和惯性垂直速度（the Inertial Vertical Velocity）
 */
@Data
public class BarometricVerticalRate {

    /**
     * uint:ft/min, LSB:6.25
     */
    private double Rate;

    public static final int length = 2;

    public BarometricVerticalRate(int[] data, int index) {
        Rate = (short)((data[index] << 8) | data[index + 1]) * 6.25;
    }

    @Override
    public String toString() {
        return Rate + "";
    }
}
