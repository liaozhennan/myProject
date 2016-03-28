package lzn.android.request;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.toolbox.ImageLoader;

import lzn.android.NetRequest;

/**
 * Created by Allen on 2016/3/24.
 */
public class requestManager {
    private Context mContext;
    private static requestManager svRequestManager;
    private NetRequest mNetRequest;
    private ImageLoader mImageLoader;

    private requestManager(Context pContext) {
        mContext = pContext;
        mNetRequest = new NetRequest(mContext);
    }

    public static synchronized requestManager getInstance(Context pContext) {
        if (svRequestManager == null) {
            svRequestManager = new requestManager(pContext.getApplicationContext());
        }
        return svRequestManager;
    }


    public void getData(String pUrl , Response.Listener pListrner , Response.ErrorListener pErrListener)
    {
        mNetRequest.doGetRequest1(pUrl,pListrner,pErrListener);
    }

    /***
     * @param t      Bean of Return type
     * @param pUrl   request of url
     *
     ***/
    public <T> T getData(T t, String pUrl)
    {



        return t;
    }
}
