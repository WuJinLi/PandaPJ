package com.example.my.panda.bean.livechina;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by My on 2016/9/6.
 */
public class LiveChinaBean {

    /**
     * title : 八达岭
     * url : http://www.ipanda.com/kehuduan/liebiao/badaling/index.json
     * type :
     * order : 1
     */

    @SerializedName("tablist")
    private List<TablistBean> tablist;
    /**
     * title : 黟县
     * url : http://www.ipanda.com/kehuduan/liebiao/PAGEjQscAxoVKOjRIpboc1oA160718/index.json
     * type :
     * order : 1
     */

    @SerializedName("alllist")
    private List<AlllistBean> alllist;

    public List<TablistBean> getTablist() {
        return tablist;
    }

    public void setTablist(List<TablistBean> tablist) {
        this.tablist = tablist;
    }

    public List<AlllistBean> getAlllist() {
        return alllist;
    }

    public void setAlllist(List<AlllistBean> alllist) {
        this.alllist = alllist;
    }




}
