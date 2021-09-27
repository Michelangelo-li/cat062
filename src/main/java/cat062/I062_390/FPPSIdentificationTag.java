package cat062.I062_390;

import lombok.Data;

/**
 *
 flight-plan processing system{=FPPS}
 */
@Data
public class FPPSIdentificationTag {

    private int SAC;

    private int SIC;

    public static final int length = 2;

    public FPPSIdentificationTag(int[] data, int index) {
        SAC = data[index];
        SIC = data[index + 1];
    }

    @Override
    public String toString() {
        return SAC + "|" + SIC;
    }

}
