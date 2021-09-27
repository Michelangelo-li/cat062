package cat062.simpleitem;

import lombok.Data;

/**
 * 航迹号
 * Unique identification of a track
 */
@Data
public class I062_040_TrackNumber {

    private int Number;

    public static final int length = 2;

    public I062_040_TrackNumber(int[] data, int index) {

        //tow-octet represent one
        Number = (data[index] << 8) | data[index + 1];
    }

    @Override
    public String toString() {
        return Number + "";
    }

}
