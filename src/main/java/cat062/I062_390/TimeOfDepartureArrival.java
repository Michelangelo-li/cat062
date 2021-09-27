package cat062.I062_390;

import lombok.Data;

@Data
public class TimeOfDepartureArrival {
    private int REP;

    private DepartureTimeOrArrivalTime[] Times;

    public static int length;

    public TimeOfDepartureArrival(int[] data, int index) {

        int currentIndex = index;

        REP = data[currentIndex];

        currentIndex += 1;

        Times = new DepartureTimeOrArrivalTime[REP];

        for (int i = 0; i < REP; i++) {
            Times[i] = new DepartureTimeOrArrivalTime(
                    (data[currentIndex] >> 3) & 0x1F,
                    (data[currentIndex] >> 1) & 0x03,
                    data[currentIndex + 1] & 0x1F,
                    data[currentIndex + 2] & 0x3F,
                    (data[currentIndex + 3] >> 7) & 0x01,
                    data[currentIndex + 3] & 0x3F);
        }

        currentIndex += 4 * REP;

        length = currentIndex - index;

    }

    @Override
    public String toString() {
        if (REP > 0) {
            StringBuilder stringBuilder = new StringBuilder(REP);

            for (DepartureTimeOrArrivalTime eachData : Times) {
                stringBuilder.append("|").append(eachData);
            }
            return stringBuilder.toString();
        } else {
            return REP + "";
        }
    }


}
