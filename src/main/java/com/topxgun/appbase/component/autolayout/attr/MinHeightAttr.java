package com.topxgun.appbase.component.autolayout.attr;

import android.os.Build;
import android.view.View;

import com.topxgun.appbase.component.autolayout.attr.*;
import com.topxgun.appbase.component.autolayout.attr.AutoAttr;

import java.lang.reflect.Field;

/**
 * Created by zhy on 15/12/24.
 */
public class MinHeightAttr extends com.topxgun.appbase.component.autolayout.attr.AutoAttr
{
    public MinHeightAttr(int pxVal, int baseWidth, int baseHeight)
    {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal()
    {
        return com.topxgun.appbase.component.autolayout.attr.Attrs.MIN_HEIGHT;
    }

    @Override
    protected boolean defaultBaseWidth()
    {
        return false;
    }

    @Override
    protected void execute(View view, int val)
    {
        try
        {
            view.setMinimumHeight(val);
//            Method setMaxWidthMethod = view.getClass().getMethod("setMinHeight", int.class);
//            setMaxWidthMethod.invoke(view, val);
        } catch (Exception ignore)
        {
        }
    }

    public static MinHeightAttr generate(int val, int baseFlag)
    {
        MinHeightAttr attr = null;
        switch (baseFlag)
        {
            case com.topxgun.appbase.component.autolayout.attr.AutoAttr.BASE_WIDTH:
                attr = new MinHeightAttr(val, com.topxgun.appbase.component.autolayout.attr.Attrs.MIN_HEIGHT, 0);
                break;
            case com.topxgun.appbase.component.autolayout.attr.AutoAttr.BASE_HEIGHT:
                attr = new MinHeightAttr(val, 0, com.topxgun.appbase.component.autolayout.attr.Attrs.MIN_HEIGHT);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new MinHeightAttr(val, 0, 0);
                break;
        }
        return attr;
    }

    public static int getMinHeight(View view)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        {
            return view.getMinimumHeight();
        } else
        {
            try
            {
                Field minHeight = view.getClass().getField("mMinHeight");
                minHeight.setAccessible(true);
                return (int) minHeight.get(view);
            } catch (Exception e)
            {
            }
        }

        return 0;
    }

}
