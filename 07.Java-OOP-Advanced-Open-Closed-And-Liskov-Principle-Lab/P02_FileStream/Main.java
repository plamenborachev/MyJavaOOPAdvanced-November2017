package P02_FileStream;

import P01_ExtendedArrayList.ExtendedArrayList;

public class Main {
    public static void main(String[] args) {
        Stream stream = new File();
        Stream stream1 = new Music();

        StreamProgressInfo streamProgressInfo = new StreamProgressInfo(stream);
        StreamProgressInfo streamProgressInfo1 = new StreamProgressInfo(stream1);
    }
}
