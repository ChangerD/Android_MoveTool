package com.topxgun.appbase.component.autolayout.attr;

import android.view.View;

import com.topxgun.appbase.component.autolayout.attr.*;
import com.topxgun.appbase.component.autolayout.attr.AutoAttr;

import java.lang.reflect.Method;

/**
 * Created by zhy on 15/12/24.
 */
public class MaxHeightAttr extends com.topxgun.appbase.component.autolayout.attr.AutoAttr
{
    public MaxHeightAttr(int pxVal, int baseWidth, int baseHeight)
    {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal()
    {
        return com.topxgun.appbase.component.autolayout.attr.Attrs.MAX_HEIGHT;
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
            Method setMaxWidthMethod = view.getClass().getMethod("setMaxHeight", int.class);
            setMaxWidthMethod.invoke(view, val);
        } catch (Exception ignore)
        {
        }
    }

    public static MaxHeightAttr generate(int val, int baseFlag)
    {
        MaxHeightAttr attr = null;
        switch (baseFlag)
        {
            case com.topxgun.appbase.component.autolayout.attr.AutoAttr.BASE_WIDTH:
                attr = new MaxHeightAttr(val, com.topxgun.appbase.component.autolayout.attr.Attrs.MAX_HEIGHT, 0);
                break;
            case com.topxgun.appbase.component.autolayout.attr.AutoAttr.BASE_HEIGHT:
                attr = new MaxHeightAttr(val, 0, com.topxgun.appbase.component.autolayout.attr.Attrs.MAX_HEIGHT);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new MaxHeightAttr(val, 0, 0);
                break;
        }
        return attr;
    }

    public static int getMaxHeight(View view)
    {
        try
        {
            Method setMaxWidthMethod = view.getClass().getMethod("getMaxHeight");
            return (int) setMaxWidthMethod.invoke(view);
        } catch (Exception ignore)
        {
        }
        return 0;
    }
}
