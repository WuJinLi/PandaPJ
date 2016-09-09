package com.example.my.panda.bean;

import com.google.gson.annotations.SerializedName;

public  class LcBean {
        @SerializedName("isp_code")
        private String ispCode;
        @SerializedName("city_code")
        private String cityCode;
        @SerializedName("provice_code")
        private String proviceCode;
        @SerializedName("country_code")
        private String countryCode;
        @SerializedName("ip")
        private String ip;

        public String getIspCode() {
            return ispCode;
        }

        public void setIspCode(String ispCode) {
            this.ispCode = ispCode;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getProviceCode() {
            return proviceCode;
        }

        public void setProviceCode(String proviceCode) {
            this.proviceCode = proviceCode;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
    }