package cat062.I062_380;

import cat062.decoder.CommonUtil;
import lombok.Data;


/**
 * 轨迹意向数据
 */
@Data
public class TrajectoryIntentData {

    private int REP;

    private IntentData[] intentDataArray;

    public static int length;

    public TrajectoryIntentData(int[] data, int index) {

        int currentIndex = index;

        REP = data[currentIndex];

        currentIndex += 1;

        intentDataArray = new IntentData[REP];

        for (int i = 0; i < REP; ) {
            intentDataArray[i] = new IntentData(
                    (data[currentIndex] >> 7) & 0x01,
                    (data[currentIndex] >> 6) & 0x01,
                    data[currentIndex] & 0x3F,
                    //toShort
                    ((data[currentIndex + 1] << 8) | data[currentIndex + 2]) * 10,
                    CommonUtil.twosComplement((data[currentIndex + 3] << 16) | (data[currentIndex + 4] << 8) | data[currentIndex + 5], 24) * 180.0 / 8388608.0,
                    CommonUtil.twosComplement((data[currentIndex + 6] << 16) | (data[currentIndex + 7] << 8) | data[currentIndex + 8], 24) * 180.0 / 8388608.0,
                    (data[currentIndex + 9] >> 4) & 0x0F,
                    (data[currentIndex + 9] >> 2) & 0x03,
                    (data[currentIndex + 9] >> 1) & 0x01,
                    data[currentIndex + 9] & 0x01,
                    (data[currentIndex + 10]<< 16) | (data[currentIndex + 11] << 8) | data[currentIndex + 12],
                    ((data[currentIndex + 13] << 8) | data[currentIndex + 14]) * 0.01);
        }
        currentIndex += 15;

        length = currentIndex - index;

    }

    @Override
    public String toString() {
        if (REP > 0) {
            StringBuilder stringBuilder = new StringBuilder(REP);

            for (IntentData eachData : intentDataArray) {
                stringBuilder.append("|").append(eachData);
            }
            return stringBuilder.toString();
        } else {
            return REP + "";
        }
    }


}
