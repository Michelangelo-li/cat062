package cat062.I062_390;

import lombok.Data;

/**
 * 呼号
 */
@Data
public class Callsign {

    private String Callsign;

    public static final int length = 7;

    public Callsign(int[] data, int index) {

        Callsign = new String(new char[]{
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
        return Callsign;
    }
}
