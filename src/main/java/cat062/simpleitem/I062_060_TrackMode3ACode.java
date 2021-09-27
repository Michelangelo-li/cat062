package cat062.simpleitem;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * * Asterix Cat 062 Item 060 - Mode 3/A - Optional
 *  * Mode-3/A code converted into octal representation.
 *
 *  https://medium.com/@mehmetcagrikose/mode-a-c-mode-s-and-ads-b-the-alphabet-soup-of-secondary-surveillance-1defcd35b2ab
 *
 * IFF equipment is called transponder, short for transmitter-responder.
 * Before or during each flight, pilots may be instructed by ATC personnel
 * to “Squawk XXXX”. XXXX in this context Mode 3/A code.
 * Mode 3/A code is temporary identity of the aircraft for that ATC.
 * The pilot then sets its transponder Mode 3/A code to requested code.
 * This code is then sent as reply to Mode 3/A interrogations by ATC.
 * Mode 3/A code can be used for purposes other than identification.
 * Some important Mode 3/A codes used for non-identification purposes are;
 * 1200: Generally used by aircraft under Visual Flight Rules(VFR)
 * 7700: Used during emergency
 * 7600: User when radio communication fails
 * 7500: Used during hijacking(unlawful interference) of the aircraft
 *
 * 8*8*8*8=4096个
 */
@Data
@NoArgsConstructor
public class I062_060_TrackMode3ACode implements Serializable {

    private int V;

    private int G;

    private int CH;

    private int Code;

    public static final int length = 2;

    public I062_060_TrackMode3ACode(int[] data, int index) {

       int b16 = (data[index] << 8) | data[index + 1];

        // >>表示右移，如果该数为正，则高位补0，若为负数，则高位补1；
        // 0x01= 0000 0001
        // 拿到最高的位置
        V = ((b16 >> 15) & 0x01);

        //拿到第二位
        G = ((b16 >> 14) & 0x01);

        //拿到CH位
        CH = ((b16 >> 13) & 0x01);

        //应答机编码
        Code = calCode(b16);

    }

    private int calCode(int b16) {
        int code = 0;

        //0x07=0000 0111 后三位
        //一开始i=9 拿到了A4A2A1 即千位
        //B4 B2 B1
        //C4 C2 C1
        //D4 D2 D1
        for (int i = 9; i >= 0; i = i - 3) {
            code = code * 10 + ((b16 >> i) & 0x07);
        }

        return code;

    }

    @Override
    public String toString() {
        return Code + "," + V + "," + G + "," + CH;
    }


}
