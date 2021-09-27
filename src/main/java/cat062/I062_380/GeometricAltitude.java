package cat062.I062_380;

import lombok.Data;

/**
 * 几何高度
 */
@Data
public class GeometricAltitude {

    /**
     * uint:ft, LSB:6.25, min:-1500, max:150000
     */
    private double Altitude;

    public static final int length = 2;

    public GeometricAltitude(int[] data, int index) {
        Altitude = (short)((data[index] << 8) | data[index + 1]) * 6.25;
    }

    @Override
    public String toString() {
        return Altitude + "";
    }

}
