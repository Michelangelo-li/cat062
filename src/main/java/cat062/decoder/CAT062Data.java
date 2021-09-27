package cat062.decoder;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class CAT062Data {

    public static final int CAT062_ID = 62;

    @Getter
    @Setter
    private long receiveTime;

    @Getter
    @Setter
    private CAT062Track[] trackArray;

    @JSONField(serialize = false)
    private List<CAT062Track> trackList;


    public CAT062Data(int[] data,int startIndex, int dataLength,long receiveTime) throws Exception {

        int currentIndex = startIndex;

        if (data[currentIndex] != CAT062_ID) {
            throw new Exception("不是ASTERIX-CAT062格式数据");
        }

        //
        int length = (data[currentIndex + 1] << 8) + data[currentIndex + 2];

//        if (dataLength != length || data.length - startIndex < dataLength) {
//            throw new Exception("ASTERIX-CAT062数据长度错误");
//        }

        currentIndex += 3;

        trackList = new ArrayList();


        //startIndex=0
        //3
        //
        while (currentIndex - startIndex < length) {
            CAT062Track track = new CAT062Track(data, currentIndex);
            trackList.add(track);
            currentIndex += CAT062Track.length;
        }

        if (currentIndex - startIndex != length) {
            throw new Exception("ASTERIX CAT062数据解析错误。");
        }

        this.trackArray = trackList.toArray(new CAT062Track[]{});

        this.receiveTime = receiveTime;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(4096);
        stringBuilder.append(receiveTime);

        for (CAT062Track track : trackList) {
            stringBuilder.append("#").append(track.toString());
        }
        return stringBuilder.toString();
    }

}
