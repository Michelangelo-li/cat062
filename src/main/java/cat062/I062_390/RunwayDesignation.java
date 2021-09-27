package cat062.I062_390;

import lombok.Data;

/**
 * 跑道名称
 */
@Data
public class RunwayDesignation {

    private char NU1;

    private char NU2;

    private char LTR;

    public static final int length = 3;

    public RunwayDesignation(int[] data, int index) {

        NU1 = (char) (byte) (data[index] & 0xFF);
        NU2 = (char) (byte) (data[index + 1] & 0xFF);
        LTR = (char) (byte) (data[index + 2] & 0xFF);
    }

    @Override
    public String toString() {
        return NU1 + "|" + NU2 + "|" + LTR;
    }

}
