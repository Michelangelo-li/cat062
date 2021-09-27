package cat062.simpleitem;

import lombok.Data;

/**
 * Cat 062 item 185 - Calculated Track Velocity - Optional
 * Calculated track velocity expressed in Cartesian co-ordinates,
 * in two’s complement form.
 * Unit of measure: 0.25 m/s
 * Validation:
 * -8192m/s ≤ Vx ≤ 8191.75m/s
 * -8192m/s ≤ Vy ≤ 8191.75m/s
 *
 * 计算的轨迹速度（笛卡尔）
 */
@Data
public class I062_185_CalculatedTrackVelocity_Cartesian {

    /**
     * uint:m/s, LSB:0.25, min:-8192, max:8191.75
     */
    private double Vx;

    /**
     * uint:m/s, LSB:0.25, min:-8192, max:8191.75
     */
    private double Vy;

    public static final int length = 4;

    public I062_185_CalculatedTrackVelocity_Cartesian(int[] data, int index) {

        //java short 数据类型是 16 位、有符号的以二进制补码表示的整数,int 数据类型是32位、有符号的以二进制补码表示的整数；
        //scala Short	16位有符号补码整数。数值区间为 -32768 到 32767
        Vx = (short)((data[index] << 8) | data[index + 1]) * 0.25;

        Vy = (short)((data[index + 2] << 8) | data[index + 3]) * 0.25;
    }

    @Override
    public String toString() {
        return Vx + "," + Vy;
    }


}
