package cat062.simpleitem;

import cat062.decoder.CommonUtil;
import lombok.Data;

/**
 * Cat 062 Item 135 - Barometric altitude - Opt
 * Calculated Barometric Altitude of the track, in two’s complement
 * form. This field also contains QNH info
 * Validation: -15FL < alt < 1500FL
 * Unit of measure: 25ft (1/4FL)
 *
 * 计算的轨道气压高度
 */
@Data
public class I062_135_CalculatedTrackBarometricAltitude {

    private int QNH;

    /**
     * uint:FL, LSB:1/4, min:-15, max:1500
     */
    private double Altitude;


    public static final int length = 2;


    public I062_135_CalculatedTrackBarometricAltitude(int[] data, int index) {

        int b16 = (data[index] << 8) | data[index + 1];
        QNH = (b16 >> 15) & 0x01;
        Altitude = CommonUtil.twosComplement(b16 & 0x7FFF, 15) / 4.0;
    }

    @Override
    public String toString() {
        return Altitude + "," + QNH;
    }


}
