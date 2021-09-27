package cat062.I062_390;

import lombok.Data;

/**
 * Aircraft Stand 停机位
 */
@Data
public class AircraftStand {

    private String Stand;

    public static final int length = 6;

    public AircraftStand(int[] data, int index) {

        Stand = new String(new char[]{
                (char) (byte) (data[index] & 0xFF),
                (char) (byte) (data[index + 1] & 0xFF),
                (char) (byte) (data[index + 2] & 0xFF),
                (char) (byte) (data[index + 3] & 0xFF),
                (char) (byte) (data[index + 4] & 0xFF),
                (char) (byte) (data[index + 5] & 0xFF)}).trim();
    }

    @Override
    public String toString() {
        return Stand;
    }


}
