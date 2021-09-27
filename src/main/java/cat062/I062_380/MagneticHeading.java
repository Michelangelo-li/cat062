package cat062.I062_380;

import lombok.Data;

/**
 * 磁航向 ，该参数可以在管制席位屏幕上直观显示，也可用于系统航迹的计算，为管制人员水平方向上的调度指挥提供更可靠的信息；
 * 飞机的航向，有真航向和磁航向、罗航向、陀螺航向、大圆航向等等
 */
@Data
public class MagneticHeading {

    /**
     * uint:°, LSB:360°/(2**16)
     */
    private double Heading;

    public static final int length = 2;

    public MagneticHeading(int[] data, int index) {
        Heading = ((data[index] << 8) | data[index + 1]) * 360.0 / 65536.0;
    }

    @Override
    public String toString() {
        return Heading + "";
    }

}
