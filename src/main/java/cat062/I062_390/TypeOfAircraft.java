package cat062.I062_390;

import lombok.Data;


/**
 * 飞机类型
 */
@Data
public class TypeOfAircraft {

    private String Type;

    public static final int length = 4;

    public TypeOfAircraft(int[] data, int index) {

        Type = new String(new char[]{
                (char) (byte) (data[index] & 0xFF),
                (char) (byte) (data[index + 1] & 0xFF),
                (char) (byte) (data[index + 2] & 0xFF),
                (char) (byte) (data[index + 3] & 0xFF),
        });

    }

    @Override
    public String toString() {
        return Type;
    }
}
