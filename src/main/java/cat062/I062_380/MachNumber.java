package cat062.I062_380;

import lombok.Data;

/**
 * 马赫，马赫数（速度单位，常用于计算飞行速度，1马赫等于音速）
 */
@Data
public class MachNumber {

    /**
     * uint:mach, LSB:0.008
     */
    private double Mach;

    public static final int length = 2;

    public MachNumber(int[] data, int index) {
        Mach = ((data[index] << 8) | data[index + 1]) * 0.008;
    }

    @Override
    public String toString() {
        return Mach + "";
    }


}
