package cat062.I062_380;

import lombok.Data;

@Data
public class ModeSMBData {

    private int REP;

    private String[] MBData;

    public static int length;

    public ModeSMBData(int[] data, int index) {

        int currentIndex = index;

        REP = data[currentIndex];

        for (int i = 0; i < REP; ) {

            MBData[i] = String.format("(%X)%X%X%X%X%X%X%X",
                    data[currentIndex + 7],
                    data[currentIndex],
                    data[currentIndex + 1],
                    data[currentIndex + 2],
                    data[currentIndex + 3],
                    data[currentIndex + 4],
                    data[currentIndex + 5],
                    data[currentIndex + 6]
            );
            currentIndex += 8;
        }

        length = currentIndex - index;

    }

    @Override
    public String toString() {
        if (REP > 0) {
            StringBuilder stringBuilder = new StringBuilder(REP);

            for (String eachMDB : MBData) {
                stringBuilder.append("|").append(eachMDB);
            }
            return stringBuilder.toString();
        } else {
            return REP + "";
        }
    }

}
