package cat062.I062_380;

import lombok.Data;

/**
 * 该参数来源于机载设备，同样也可以用地面设备测量得出
 */
@Data
public class GroundSpeed {
    /**
     * uint:NM/s, LSB:2**-14
     */
    private double Speed;

    public static final int length = 2;

    public GroundSpeed(int[] data, int index) {
        Speed = (short)((data[index] << 8) | data[index + 1]) * 0.00006103515625;
    }

    @Override
    public String toString() {
        return Speed + "";
    }


}
