package cat062.I062_390;

import lombok.Data;

/**
 * 航班类别
 */
@Data
public class FlightCategory {

    private int GAT_OAT;

    private int FR1_FR2;

    private int RVSM;

    private int HPR;

    public static final int length = 1;

    public FlightCategory(int[] data, int index) {

       int originalByte = data[index];

        GAT_OAT = (originalByte >> 6) & 0x03;
        FR1_FR2 = (originalByte >> 4) & 0x03;
        RVSM = (originalByte >> 2) & 0x03;
        HPR = (originalByte >> 1) & 0x01;
    }


    @Override
    public String toString() {
        return GAT_OAT + "|" + FR1_FR2 + "|" + RVSM + "|" + HPR;
    }


}
