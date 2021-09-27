package cat062.I062_380;

import lombok.Data;

/**
 *机载应答机状态和机载ACAS设备状态以及飞机状态
 */
@Data
public class CommunicationsACASCapabilityAndFlightStatus {

    private int COM;

    private int STAT;

    private int SSC;

    private int ARC;

    private int AIC;

    private int B1A;

    private int B1B;

    public static final int length = 2;

    public CommunicationsACASCapabilityAndFlightStatus(int[] data, int index) {

        int originalByte = data[index];

        COM = (originalByte >> 5) & 0x07; //0x07=0000 0111
        STAT = (originalByte >> 2) & 0x07;

        originalByte = data[index + 1];

        SSC = (originalByte >> 7) & 0x01;
        ARC = (originalByte >> 6) & 0x01;
        AIC = (originalByte >> 5) & 0x01;
        B1A = (originalByte >> 4) & 0x01;
        B1B = originalByte & 0x0F; //0000 1111
    }


    @Override
    public String toString() {
        return COM + "|" + STAT + "|" + SSC + "|" + ARC + "|" + AIC + "|" + B1A + "|" + B1B;
    }


}
