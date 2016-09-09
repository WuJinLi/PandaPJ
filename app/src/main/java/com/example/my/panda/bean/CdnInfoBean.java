package com.example.my.panda.bean;

import com.google.gson.annotations.SerializedName;

public  class CdnInfoBean {
        @SerializedName("cdn_vip")
        private String cdnVip;
        @SerializedName("cdn_code")
        private String cdnCode;
        @SerializedName("cdn_name")
        private String cdnName;

        public String getCdnVip() {
            return cdnVip;
        }

        public void setCdnVip(String cdnVip) {
            this.cdnVip = cdnVip;
        }

        public String getCdnCode() {
            return cdnCode;
        }

        public void setCdnCode(String cdnCode) {
            this.cdnCode = cdnCode;
        }

        public String getCdnName() {
            return cdnName;
        }

        public void setCdnName(String cdnName) {
            this.cdnName = cdnName;
        }
    }