package cat062.simpleitem;

import cat062.decoder.CommonUtil;
import lombok.Data;

/**
 * 飞机在笛卡尔坐标系即直角坐标系下的位置
 *  Cat 062 Item 100 - Calculated Track Position (Cartesian) - Optional
 *  Calculated position in Cartesian co-ordinates with a resolution of
 *  0.5m, in two’s complement form
 *
 *  计算的轨迹的位置（笛卡尔）
 */
@Data
public class I062_100_CalculatedTrackPosition_Cartesian {

    /**
     * unit:m, LSB:0.5
     */
    private double X;

    /**
     * unit:m, LSB:0.5
     */
    private double Y;

    public static final int length = 6;

    public I062_100_CalculatedTrackPosition_Cartesian(int[] data, int index) {

        X = CommonUtil.twosComplement((data[index] << 16) | (data[index + 1] << 8) | data[index + 2], 24) * 0.5;

        Y = CommonUtil.twosComplement((data[index + 3] << 16) | (data[index + 4] << 8) | data[index + 5], 24) * 0.5;
    }

    @Override
    public String toString() {
        return X + "," + Y;
    }


}
