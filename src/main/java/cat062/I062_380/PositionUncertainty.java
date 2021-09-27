package cat062.I062_380;

import lombok.Data;

@Data
public class PositionUncertainty {

    private int PUN;

    public static final int length = 1;

    public PositionUncertainty(int[] data, int index) {
        PUN = data[index] & 0x0F;
    }

    @Override
    public String toString() {
        return PUN + "";
    }


}
