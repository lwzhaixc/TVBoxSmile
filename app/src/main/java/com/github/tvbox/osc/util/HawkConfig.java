package com.github.tvbox.osc.util;

import android.util.Log;
import android.widget.Toast;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;

/**
 * @author pj567
 * @date :2020/12/23
 * @description:
 */
public class HawkConfig {
    public static final String API_URL = "api_url";
    public static final String API_URL_NAME_SPLIT_CHAR = "#[SPLIT]#";
    public static final String API_URL_NAME = "api_name";
    public static final String API_HISTORY = "api_history";
    public static final String API_HISTORY_WITH_NAME = "api_history_name";
    public static final String HOME_API = "home_api";
    public static final String DEFAULT_PARSE = "parse_default";
    public static final String DEBUG_OPEN = "debug_open";
    public static final String PARSE_WEBVIEW = "parse_webview"; // true 系统 false xwalk
    public static final String IJK_CODEC = "ijk_codec";
    public static final String PLAY_TYPE = "play_type";//0 系统 1 ijk 2 exo 10 MXPlayer
    public static final String PLAY_RENDER = "play_render"; //0 texture 2
    public static final String PLAY_SCALE = "play_scale"; //0 texture 2
    public static final String PLAY_TIME_STEP = "play_time_step"; //0 texture 2
    public static final String DOH_URL = "doh_url";
    public static final String HOME_REC = "home_rec"; // 0 豆瓣热播 1 数据源推荐 2 历史
    public static final String SEARCH_VIEW = "search_view"; // 0 列表 1 缩略图
    public static final String LIVE_CHANNEL = "last_live_channel_name";
    public static final String LIVE_CHANNEL_REVERSE = "live_channel_reverse";
    public static final String LIVE_CROSS_GROUP = "live_cross_group";
    public static final String LIVE_CONNECT_TIMEOUT = "live_connect_timeout";
    public static final String LIVE_SHOW_NET_SPEED = "live_show_net_speed";
    public static final String LIVE_SHOW_TIME = "live_show_time";

    public static String getApiUrlName(String url){
        String nameTxt = "default";
        ArrayList<String> historyNewApiName = Hawk.get(HawkConfig.API_HISTORY_WITH_NAME, new ArrayList<String>());
        Log.e("mytest",historyNewApiName.size()+"");
        for(int i=0;i<historyNewApiName.size();i++)
        {
            //Toast.makeText(getContext(),historyNewApiName.get(i),Toast.LENGTH_SHORT).show();
            Log.e("mytest",historyNewApiName.get(i));
            if(!historyNewApiName.get(i).contains(HawkConfig.API_URL_NAME_SPLIT_CHAR))
                continue;
            String[] splitRes = historyNewApiName.get(i).split(HawkConfig.API_URL_NAME_SPLIT_CHAR);
            if(splitRes[1].equals(url)) {
                nameTxt = splitRes[0];
                break;
            }
        }
        return  nameTxt;
    }
}