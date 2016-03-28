package lzn.android;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;

import lzn.android.request.RequestQueueSingleLeton;

/**
 * Created by Allen on 2016/3/24.
 */
public class NetRequest {
    private Context mvContext;
    private RequestQueueSingleLeton mRequestSingleton;
    private ImageLoader mImageLoader;
    // Instantiate the RequestQueue.
    RequestQueue queue;
    String url = "http://www.baidu.com";//http://www.weather.com.cn/data/cityinfo/101010100.html

    public NetRequest(Context pContext) {
        mvContext = pContext;
        mRequestSingleton = RequestQueueSingleLeton.getInstance(pContext);
        queue = mRequestSingleton.getRequestQueue();
        mImageLoader = mRequestSingleton.getImageLoader();
    }

    public void doGetRequest1(String pUrl , Response.Listener pListrner , Response.ErrorListener pErrListener) {
        StringRequest lvStringRequest = new StringRequest(Request.Method.POST, url, pListrner, pErrListener);
        queue.add(lvStringRequest);
    }
    public void getImage(String pUrl , Response.Listener pListrner ,int pMaxWidth, int pMaxHeight,Bitmap.Config pConfig ,Response.ErrorListener pErrListener)
    {
        ImageRequest lvImageRequest = new ImageRequest(pUrl,pListrner,pMaxWidth,pMaxHeight,pConfig,pErrListener);
        queue.add(lvImageRequest);
    }

}
