package cat062.I062_380;

import lombok.Data;

/**
 *
 */
@Data
public class StatusReportedByADSB {

    private int AC;

    private int MN;

    private int DC;

    private int GBS;

    private int STAT;


    public static final int length = 2;

    public StatusReportedByADSB(int[] data, int index) {

        int originalByte = data[index];

        AC = (originalByte >> 6) & 0x03;
        MN = (originalByte >> 4) & 0x03;
        DC = (originalByte >> 2) & 0x03;
        GBS = (originalByte >> 1) & 0x01;
        originalByte = data[index + 1];

        STAT = originalByte & 0x07;
    }


    @Override
    public String toString() {
        return AC + "|" + MN + "|" + DC + "|" + GBS + "|" + STAT;
    }
}
