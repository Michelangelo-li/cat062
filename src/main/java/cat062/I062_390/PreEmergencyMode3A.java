package cat062.I062_390;

import lombok.Data;

@Data
public class PreEmergencyMode3A {

    private int VA;

    private int Code;

    public static final int length = 2;

    public PreEmergencyMode3A(int[] data, int index) {

        int b16 = (data[index] << 8) | data[index + 1];

        VA = (b16 >> 12) & 0x01;

        int tmpCode = 0;

        for (int i = 9; i >= 0; i -= 3) {
            tmpCode = tmpCode * 10 + ((b16 >> i) & 0x07);
        }

        Code = tmpCode;
    }


    @Override
    public String toString() {
        return Code + "|" + VA;
    }


}
