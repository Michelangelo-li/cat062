package cat062.simpleitem;

import cat062.decoder.CommonUtil;
import lombok.Data;


/**
 * Cat 062 Item 245 - Target (aircraft or vehicle) identification in 8 characters.
 * @implSpec  Item is not used any more according to Asterix ICD
 *
 * 目标识别
 *
 */
@Data
public class I062_245_TargetIdentification {


    private int STI;

    private String Identification;

    public static final int length = 7;

    //toshort
    public I062_245_TargetIdentification(int[] data, int index) {

        STI = (data[index] >> 6) & 0x03;

        Identification = CommonUtil.bytesToCallsign(
                new int[]{data[index + 1], data[index + 2], data[index + 3], data[index + 4], data[index + 5], data[index + 6]}
        );
    }

    @Override
    public String toString() {
        return Identification + "," + STI;
    }


}
