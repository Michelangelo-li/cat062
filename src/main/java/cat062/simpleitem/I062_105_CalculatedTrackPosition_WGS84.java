package cat062.simpleitem;


import lombok.Data;

/**
 * 飞机在WGS84坐标系下的位置
 *  * Cat 062 Item 105 - Calculated Position in WSG84 coordinates - Optional
 *  * Unit of measure for lat and lon is 180/pow(2,25). degrees'
 *  计算轨迹的位置（WGS-84）
 */
@Data
public class I062_105_CalculatedTrackPosition_WGS84 {

    /**
     * 维度
     * uint:°, LSB:180°/(2**25)=180°/33554432
     */
    private double Latitude;

    /**
     * 经度
     * uint:°, LSB:180°/(2**25)=180°/33554432
     */
    private double Longitude;

    public static final int length = 8;

    //|（按位或）
    public I062_105_CalculatedTrackPosition_WGS84(int[] data, int index) {


        // byte[] input, int offset
        // input[offset] * 256 * 256 * 256 +
        //                        Byte.toUnsignedInt(input[offset + 1]) * 256 * 256 +
        //                        Byte.toUnsignedInt(input[offset + 2]) * 256 +
        //                        Byte.toUnsignedInt(input[offset + 3]);
        Latitude = ((data[index] << 24) | (data[index + 1] << 16) | (data[index + 2] << 8) | data[index + 3]) * 180.0 / 33554432.0;

        Longitude = ((data[index + 4] << 24) | (data[index + 5] << 16) | (data[index + 6] << 8) | data[index + 7]) * 180.0 / 33554432.0;
    }

    @Override
    public String toString() {
        return Latitude + "," + Longitude;
    }

}
