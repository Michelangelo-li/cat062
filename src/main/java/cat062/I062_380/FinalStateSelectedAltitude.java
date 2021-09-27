package cat062.I062_380;

import cat062.decoder.CommonUtil;
import lombok.Data;

/**
 * 最终状态选择高度
 */
@Data
public class FinalStateSelectedAltitude {

    private int MV;

    private int AH;

    private int AM;

    /**
     * uint:ft, LSB:25
     */
    private int Altitude;

    public static final int length = 2;


    public FinalStateSelectedAltitude(int[] data, int index) {

        int b16 = (data[index] << 8) | data[index + 1];

        MV = (b16 >> 15) & 0x01;
        AH = (b16 >> 14) & 0x01;
        AM = (b16 >> 13) & 0x01;
        Altitude = CommonUtil.twosComplement(b16 & 0x1FFF, 13) * 25;

    }


    @Override
    public String toString() {
        return Altitude + "|" + MV + "|" + AH + "|" + AM;
    }


}
