package text.bwei.com.yukao11yue.bean;

/**
 * Created by dell on 2017/12/7.
 */

public class MessEvent {
    //    mediaId=e4871e503816456eb5ae84758d70d0dd
    String mediaId;
    String title;

//    public MessEvent(String mediaId) {
//        this.mediaId = mediaId;
//    }
//
//    public String getMediaId() {
//        return mediaId;
//    }


    public MessEvent(String mediaId, String title) {
        this.mediaId = mediaId;
        this.title = title;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getTitle() {
        return title;
    }
}
