package cat062.I062_390;

import lombok.Data;

@Data
public class CurrentControlPosition {

    private int Centre;

    private int Position;

    public static final int length = 2;

    public CurrentControlPosition(int[] data, int index) {

        Centre = data[index];
        Position = data[index + 1];
    }

    @Override
    public String toString() {
        return Centre + "|" + Position;
    }


}
