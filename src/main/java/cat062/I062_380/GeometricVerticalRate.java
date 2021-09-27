package cat062.I062_380;

import lombok.Data;

/**
 * 几何垂直速率
 */
@Data
public class GeometricVerticalRate {

    /**
     * uint:ft/min, LSB:6.25
     */
    private double Rate;

    public static final int length = 2;

    public GeometricVerticalRate(int[] data, int index) {
        Rate = (short)((data[index] << 8) | data[index + 1]) * 6.25;
    }

    @Override
    public String toString() {
        return Rate + "";
    }

}
