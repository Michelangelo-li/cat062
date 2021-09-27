package cat062.I062_380;

import cat062.decoder.CommonUtil;
import lombok.Data;

/**
 *"identification": "CBJ431"
 */
@Data
public class TargetIdentification {

    private String Identification;

    public static final int length = 6;

    public TargetIdentification(int[] data, int index) {
        Identification = CommonUtil.bytesToCallsign(new int[]{
                data[index],
                data[index + 1],
                data[index + 2],
                data[index + 3],
                data[index + 4],
                data[index + 5]});
    }


    @Override
    public String toString() {
        return Identification;
    }
}