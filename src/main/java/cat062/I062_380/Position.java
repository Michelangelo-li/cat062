package cat062.I062_380;

import cat062.decoder.CommonUtil;
import lombok.Data;

@Data
public class Position {

    /**
     * uint:°, LSB:180°/(2**23)=180°/8388608 纬度
     */
    private double Latitude;


    /**
     * uint:°, LSB:180°/(2**23)=180°/8388608 经度
     */
    private double Longitude;


    public static final int length = 6;

    public Position(int[] data, int index) {
        Latitude =
                CommonUtil.twosComplement((data[index] << 16) | (data[index + 1] << 8) | data[index + 2], 24) * 180.0 / 8388608.0;

        Longitude =
                CommonUtil.twosComplement((data[index + 3] << 16) | (data[index + 4] << 8) | data[index + 5], 24) * 180.0 / 8388608.0;
    }


    @Override
    public String toString() {
        return Latitude + "|" + Longitude;
    }


}
