package text.bwei.com.yukao11yue.bean;

import java.util.List;

/**
 * Created by dell on 2017/12/8.
 */

public class Pinlun {

    /**
     * msg : 成功
     * ret : {"pnum":1,"totalRecords":13,"records":20,"list":[{"msg":"女孩的校园剧，女生小团体，反欺凌之类的，根据兴趣看吧","phoneNumber":"頡頏Sammy","dataId":"ff8080815f6b5cd5015f9c08945526c5","userPic":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLNL7wibB1VcR45Fdp1ezKZdiaeNC9lIwQDPceDwlxvDEW0Yicdmc86zlgibvic9dohIK4dWMunyyEZSibA/0","time":"2017-11-08 22:28:48","likeNum":0},{"msg":"怎么缓存啊","phoneNumber":"-清溪溪溪-","dataId":"ff8080815e610248015e61d0ab5e0ac3","userPic":"http://tvax2.sinaimg.cn/crop.0.0.750.750.1024/a2495607ly8fgw7z2cgjrj20ku0ku3zu.jpg","time":"2017-09-08 22:06:58","likeNum":4},{"msg":"老电影了，再看一遍","phoneNumber":"卫清｜张卫庆","dataId":"ff8080815e51a154015e57576a9f3185","userPic":"http://q.qlogo.cn/qqapp/1101034181/ED6125E47EEFDDF1CC8FDFE0BEA4CA83/40","time":"2017-09-06 21:18:20","likeNum":0},{"msg":"什么破电影","phoneNumber":"老邻居","dataId":"ff8080815e192b12015e20bf7ff20f40","userPic":"http://images.svipmovie.com/0","time":"2017-08-27 06:52:54","likeNum":0},{"msg":"快点了","phoneNumber":"起点＆延续","dataId":"ff8080815e192b12015e19e712390297","userPic":"http://q.qlogo.cn/qqapp/1101034181/EDD5420D528F59F857E7A053847D0EAF/40","time":"2017-08-25 22:58:47","likeNum":1},{"msg":"没有啥没有什么好看的","phoneNumber":"起点＆延续","dataId":"ff8080815e192b12015e19e12916027b","userPic":"http://q.qlogo.cn/qqapp/1101034181/EDD5420D528F59F857E7A053847D0EAF/40","time":"2017-08-25 22:52:20","likeNum":0},{"msg":"这是什么东西","phoneNumber":"起点＆延续","dataId":"ff8080815e192b12015e19e09a0a0279","userPic":"http://q.qlogo.cn/qqapp/1101034181/EDD5420D528F59F857E7A053847D0EAF/40","time":"2017-08-25 22:51:43","likeNum":0},{"msg":"看来古今中外纯情的女孩才容易找到真爱。。。","phoneNumber":"18229390628","dataId":"ff8080815d63ecd5015d6e4a622302be","userPic":"","time":"2017-07-23 15:12:34","likeNum":1},{"msg":"我给5分","phoneNumber":"刘亦阳","dataId":"ff8080815ce74911015ce7eae16607d1","userPic":"http://q.qlogo.cn/qqapp/1101034181/9641FFEFA822EB3D00846587A57591D2/40","time":"2017-06-27 12:59:09","likeNum":0},{"msg":"整体一般，不推荐，除非你很有空。","phoneNumber":"伪笑醉相思","dataId":"ff8080815c9b961b015ca976f409630a","userPic":"","time":"2017-06-15 10:11:04","likeNum":2},{"msg":"打算把这个电影推荐给某人看看，哈哈~","phoneNumber":"一人一心一世界","dataId":"ff8080815c9b961b015ca976f427630b","userPic":"","time":"2017-05-25 05:56:04","likeNum":3},{"msg":"我给这个片子7分，还有上升空间。","phoneNumber":"假如回忆不再","dataId":"ff8080815c9b961b015ca976f4076309","userPic":"","time":"2017-05-24 00:07:04","likeNum":3},{"msg":"这电影看完之后让我无话可说，不过好的一点是：让我看完了。。。。","phoneNumber":"离开我以后","dataId":"ff8080815c9b961b015ca976f4046308","userPic":"","time":"2017-05-07 12:16:04","likeNum":0}],"totalPnum":1}
     * code : 200
     */

    private String msg;
    private RetBean ret;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RetBean getRet() {
        return ret;
    }

    public void setRet(RetBean ret) {
        this.ret = ret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class RetBean {
        /**
         * pnum : 1
         * totalRecords : 13
         * records : 20
         * list : [{"msg":"女孩的校园剧，女生小团体，反欺凌之类的，根据兴趣看吧","phoneNumber":"頡頏Sammy","dataId":"ff8080815f6b5cd5015f9c08945526c5","userPic":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLNL7wibB1VcR45Fdp1ezKZdiaeNC9lIwQDPceDwlxvDEW0Yicdmc86zlgibvic9dohIK4dWMunyyEZSibA/0","time":"2017-11-08 22:28:48","likeNum":0},{"msg":"怎么缓存啊","phoneNumber":"-清溪溪溪-","dataId":"ff8080815e610248015e61d0ab5e0ac3","userPic":"http://tvax2.sinaimg.cn/crop.0.0.750.750.1024/a2495607ly8fgw7z2cgjrj20ku0ku3zu.jpg","time":"2017-09-08 22:06:58","likeNum":4},{"msg":"老电影了，再看一遍","phoneNumber":"卫清｜张卫庆","dataId":"ff8080815e51a154015e57576a9f3185","userPic":"http://q.qlogo.cn/qqapp/1101034181/ED6125E47EEFDDF1CC8FDFE0BEA4CA83/40","time":"2017-09-06 21:18:20","likeNum":0},{"msg":"什么破电影","phoneNumber":"老邻居","dataId":"ff8080815e192b12015e20bf7ff20f40","userPic":"http://images.svipmovie.com/0","time":"2017-08-27 06:52:54","likeNum":0},{"msg":"快点了","phoneNumber":"起点＆延续","dataId":"ff8080815e192b12015e19e712390297","userPic":"http://q.qlogo.cn/qqapp/1101034181/EDD5420D528F59F857E7A053847D0EAF/40","time":"2017-08-25 22:58:47","likeNum":1},{"msg":"没有啥没有什么好看的","phoneNumber":"起点＆延续","dataId":"ff8080815e192b12015e19e12916027b","userPic":"http://q.qlogo.cn/qqapp/1101034181/EDD5420D528F59F857E7A053847D0EAF/40","time":"2017-08-25 22:52:20","likeNum":0},{"msg":"这是什么东西","phoneNumber":"起点＆延续","dataId":"ff8080815e192b12015e19e09a0a0279","userPic":"http://q.qlogo.cn/qqapp/1101034181/EDD5420D528F59F857E7A053847D0EAF/40","time":"2017-08-25 22:51:43","likeNum":0},{"msg":"看来古今中外纯情的女孩才容易找到真爱。。。","phoneNumber":"18229390628","dataId":"ff8080815d63ecd5015d6e4a622302be","userPic":"","time":"2017-07-23 15:12:34","likeNum":1},{"msg":"我给5分","phoneNumber":"刘亦阳","dataId":"ff8080815ce74911015ce7eae16607d1","userPic":"http://q.qlogo.cn/qqapp/1101034181/9641FFEFA822EB3D00846587A57591D2/40","time":"2017-06-27 12:59:09","likeNum":0},{"msg":"整体一般，不推荐，除非你很有空。","phoneNumber":"伪笑醉相思","dataId":"ff8080815c9b961b015ca976f409630a","userPic":"","time":"2017-06-15 10:11:04","likeNum":2},{"msg":"打算把这个电影推荐给某人看看，哈哈~","phoneNumber":"一人一心一世界","dataId":"ff8080815c9b961b015ca976f427630b","userPic":"","time":"2017-05-25 05:56:04","likeNum":3},{"msg":"我给这个片子7分，还有上升空间。","phoneNumber":"假如回忆不再","dataId":"ff8080815c9b961b015ca976f4076309","userPic":"","time":"2017-05-24 00:07:04","likeNum":3},{"msg":"这电影看完之后让我无话可说，不过好的一点是：让我看完了。。。。","phoneNumber":"离开我以后","dataId":"ff8080815c9b961b015ca976f4046308","userPic":"","time":"2017-05-07 12:16:04","likeNum":0}]
         * totalPnum : 1
         */

        private int pnum;
        private int totalRecords;
        private int records;
        private int totalPnum;
        private List<ListBean> list;

        public int getPnum() {
            return pnum;
        }

        public void setPnum(int pnum) {
            this.pnum = pnum;
        }

        public int getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            this.totalRecords = totalRecords;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public int getTotalPnum() {
            return totalPnum;
        }

        public void setTotalPnum(int totalPnum) {
            this.totalPnum = totalPnum;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * msg : 女孩的校园剧，女生小团体，反欺凌之类的，根据兴趣看吧
             * phoneNumber : 頡頏Sammy
             * dataId : ff8080815f6b5cd5015f9c08945526c5
             * userPic : http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLNL7wibB1VcR45Fdp1ezKZdiaeNC9lIwQDPceDwlxvDEW0Yicdmc86zlgibvic9dohIK4dWMunyyEZSibA/0
             * time : 2017-11-08 22:28:48
             * likeNum : 0
             */

            private String msg;
            private String phoneNumber;
            private String dataId;
            private String userPic;
            private String time;
            private int likeNum;

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public String getUserPic() {
                return userPic;
            }

            public void setUserPic(String userPic) {
                this.userPic = userPic;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }
        }
    }
}
