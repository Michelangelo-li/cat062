package cat062.simpleitem;


import lombok.Data;


/**
 * Cat 062 Item 130 - Calculated Track Geometric Altitude - Opt
 * Vertical distance between the target and the projection of its
 * position on the earth’s ellipsoid, as defined by WGS84, in two’s
 * complement form
 *
 * @implSpec The source of altitude is identified in bits (SRC)
 * of item I062/080 Track Status
 * Validation: -1500 ft < ga < 150000 ft
 * Unit of measure: 6.25 ft
 *
 * 计算出的轨道几何高度
 *
 */
@Data
public class I062_130_CalculatedTrackGeometricAltitude {

    /**
     * uint:ft, LSB:6.25, min:-1500, max:150000
     */
    private double Altitude;


    public static final int length = 2;

    //	16位有符号补码整数。数值区间为 -32768 到 32767 toShort
    //	32位有符号补码整数。数值区间为 -2147483648 到 2147483647
    public I062_130_CalculatedTrackGeometricAltitude(int[] data, int index) {
        Altitude = ((data[index] << 8) | data[index + 1])* 6.25;
    }

    @Override
    public String toString() {
        return Altitude + "";
    }


}
