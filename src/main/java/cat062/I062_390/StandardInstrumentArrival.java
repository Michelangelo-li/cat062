package cat062.I062_390;

import lombok.Data;

/**
 * 降落程序
 */
@Data
public class StandardInstrumentArrival {

    private String SIA;

    public static final int length = 7;

    public StandardInstrumentArrival(int[] data, int index) {

        SIA = new String(new char[]{
                (char) (byte) (data[index] & 0xFF),
                (char) (byte) (data[index + 1] & 0xFF),
                (char) (byte) (data[index + 2] & 0xFF),
                (char) (byte) (data[index + 3] & 0xFF),
                (char) (byte) (data[index + 4] & 0xFF),
                (char) (byte) (data[index + 5] & 0xFF),
                (char) (byte) (data[index + 6] & 0xFF)
        });
    }

    @Override
    public String toString() {
        return SIA;
    }
}
