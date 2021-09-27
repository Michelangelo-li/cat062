package cat062.I062_380;

import cat062.decoder.CommonUtil;
import lombok.Data;

/**
 * Track Angle Rater parameter
 * 該参数为目标的转向速度，也被称为Rate of Turn parameter，
 * 其在自动化系统中进行融汇计算时可以起到与Roll Angle和True Airspeed融汇计算一样的作用
 */
@Data
public class TrackAngleRate {

    /**
     * uint:°/s, LSB:1/4
     */
    private double Rate;

    private int TI;

    public static final int length = 2;

    public TrackAngleRate(int[] data, int index) {
        TI = (data[index] >> 6) & 0x03;
        Rate = CommonUtil.twosComplement((data[index + 1] >> 1) & 0x7F, 7) / 4.0;

    }

    @Override
    public String toString() {
        return Rate + "|" + TI;
    }

}
