package com.example.my.panda.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class VideoBean {
        @SerializedName("totalLength")
        private String totalLength;
        @SerializedName("validChapterNum")
        private int validChapterNum;
        @SerializedName("url")
        private String url;
        /**
         * duration : 54
         * image : http://p5.img.cctvpic
         * .com/fmspic/2016/09/06/7e9facbf34e9450ab5560e28aef7aaba-37.jpg
         * url : http://vod.cntv.lxdns
         * .com/flash/mp4video55/TMS/2016/09/06
         * /7e9facbf34e9450ab5560e28aef7aaba_h264418000nero_aac32.mp4
         */

        @SerializedName("chapters")
        private List<ChaptersBean> chapters;
        /**
         * duration : 54
         * image : http://p5.img.cctvpic
         * .com/fmspic/2016/09/06/7e9facbf34e9450ab5560e28aef7aaba-37.jpg
         * url : http://vod.cntv.lxdns
         * .com/flash/mp4video55/TMS/2016/09/06
         * /7e9facbf34e9450ab5560e28aef7aaba_h2642000000nero_aac16.mp4
         */

        @SerializedName("chapters4")
        private List<Chapters4Bean> chapters4;
        /**
         * duration : 54
         * image : http://p5.img.cctvpic
         * .com/fmspic/2016/09/06/7e9facbf34e9450ab5560e28aef7aaba-37.jpg
         * url : http://vod.cntv.lxdns
         * .com/flash/mp4video55/TMS/2016/09/06
         * /7e9facbf34e9450ab5560e28aef7aaba_h2641200000nero_aac16.mp4
         */

        @SerializedName("chapters3")
        private List<Chapters3Bean> chapters3;
        /**
         * duration : 54
         * image : http://p5.img.cctvpic
         * .com/fmspic/2016/09/06/7e9facbf34e9450ab5560e28aef7aaba-37.jpg
         * url : http://vod.cntv.lxdns
         * .com/flash/mp4video55/TMS/2016/09/06
         * /7e9facbf34e9450ab5560e28aef7aaba_h264200000nero_aac16.mp4
         */

        @SerializedName("lowChapters")
        private List<LowChaptersBean> lowChapters;
        /**
         * duration : 54
         * image : http://p5.img.cctvpic
         * .com/fmspic/2016/09/06/7e9facbf34e9450ab5560e28aef7aaba-37.jpg
         * url : http://vod.cntv.lxdns
         * .com/flash/mp4video55/TMS/2016/09/06
         * /7e9facbf34e9450ab5560e28aef7aaba_h264818000nero_aac32.mp4
         */

        @SerializedName("chapters2")
        private List<Chapters2Bean> chapters2;

        public String getTotalLength() {
            return totalLength;
        }

        public void setTotalLength(String totalLength) {
            this.totalLength = totalLength;
        }

        public int getValidChapterNum() {
            return validChapterNum;
        }

        public void setValidChapterNum(int validChapterNum) {
            this.validChapterNum = validChapterNum;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<ChaptersBean> getChapters() {
            return chapters;
        }

        public void setChapters(List<ChaptersBean> chapters) {
            this.chapters = chapters;
        }

        public List<Chapters4Bean> getChapters4() {
            return chapters4;
        }

        public void setChapters4(List<Chapters4Bean> chapters4) {
            this.chapters4 = chapters4;
        }

        public List<Chapters3Bean> getChapters3() {
            return chapters3;
        }

        public void setChapters3(List<Chapters3Bean> chapters3) {
            this.chapters3 = chapters3;
        }

        public List<LowChaptersBean> getLowChapters() {
            return lowChapters;
        }

        public void setLowChapters(List<LowChaptersBean> lowChapters) {
            this.lowChapters = lowChapters;
        }

        public List<Chapters2Bean> getChapters2() {
            return chapters2;
        }

        public void setChapters2(List<Chapters2Bean> chapters2) {
            this.chapters2 = chapters2;
        }

        public static class ChaptersBean {
            @SerializedName("duration")
            private String duration;
            @SerializedName("image")
            private String image;
            @SerializedName("url")
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class Chapters4Bean {
            @SerializedName("duration")
            private String duration;
            @SerializedName("image")
            private String image;
            @SerializedName("url")
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class Chapters3Bean {
            @SerializedName("duration")
            private String duration;
            @SerializedName("image")
            private String image;
            @SerializedName("url")
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class LowChaptersBean {
            @SerializedName("duration")
            private String duration;
            @SerializedName("image")
            private String image;
            @SerializedName("url")
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class Chapters2Bean {
            @SerializedName("duration")
            private String duration;
            @SerializedName("image")
            private String image;
            @SerializedName("url")
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }