package cat062.I062_380;

import lombok.Data;

/**
 * 轨迹意图状态
 */
@Data
public class TrajectoryIntentStatus {

    private int NAV;

    private int NVB;

    public static final int length = 1;

    public TrajectoryIntentStatus(int[] data, int index) {

       int  originalByte = data[index];
        NAV = (originalByte >> 7) & 0x01;
        NVB = (originalByte >> 6) & 0x01;
    }


    @Override
    public String toString() {
        return NAV + "|" + NVB;
    }
}
