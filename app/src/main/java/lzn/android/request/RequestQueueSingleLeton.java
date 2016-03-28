package lzn.android.request;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import lzn.android.utils.LruBitmapCache;

/**
 * Created by Allen on 2016/3/24.
 */
public class RequestQueueSingleLeton {
    private static RequestQueueSingleLeton mvInstance;
    private RequestQueue mRequestQueue ;
    private ImageLoader mImageLoader;
    private Context mContext;

    public RequestQueueSingleLeton(Context pContext)
    {
        mContext = pContext;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized RequestQueueSingleLeton getInstance(Context pContext)
    {
        if(mvInstance == null)
        {
            mvInstance = new RequestQueueSingleLeton(pContext.getApplicationContext());
        }
        return  mvInstance;
    }
    public RequestQueue getRequestQueue(){
        if(mRequestQueue == null)
        {
            mRequestQueue = Volley.newRequestQueue(mContext);
        }
        return mRequestQueue;
    }
    public ImageLoader getImageLoader(){
        if (mImageLoader == null)
        {
            mImageLoader = new ImageLoader(getRequestQueue(), new ImageLoader.ImageCache() {
                LruBitmapCache cache = new LruBitmapCache(mContext);
//                private final LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(20);
                @Override
                public Bitmap getBitmap(String url) {
                    return cache.get(url);
                }

                @Override
                public void putBitmap(String url, Bitmap bitmap) {
                    cache.put(url,bitmap);
                }
            });
        }
        return  mImageLoader;
    }
}
