package cat062.simpleitem;

import lombok.Data;

/**
 * 运动方式
 */
@Data
public class I062_200_ModeOfMovement {

    private int TRANS;

    private int LONG;

    private int VERT;

    private int ADF;

    public static final int length = 1;

    public I062_200_ModeOfMovement(int[] data, int index) {

        int originalByte = data[index];

        TRANS = ((originalByte >> 6) & 0x03); //0011

        LONG = ((originalByte >> 4) & 0x03);

        VERT = ((originalByte >> 2) & 0x03);

        ADF = ((originalByte >> 1) & 0x01);
    }


    @Override
    public String toString() {
        return TRANS + "," + LONG + "," + VERT + "," + ADF;
    }

}
