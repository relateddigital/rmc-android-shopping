package com.melikeey.shoppingdemo;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.melikeey.shoppingdemo.databinding.FragmentBasketBindingImpl;
import com.melikeey.shoppingdemo.databinding.FragmentHomeBindingImpl;
import com.melikeey.shoppingdemo.databinding.FragmentProductDetailBindingImpl;
import com.melikeey.shoppingdemo.databinding.FragmentProfileBindingImpl;
import com.melikeey.shoppingdemo.databinding.FragmentShippingBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTBASKET = 1;

  private static final int LAYOUT_FRAGMENTHOME = 2;

  private static final int LAYOUT_FRAGMENTPRODUCTDETAIL = 3;

  private static final int LAYOUT_FRAGMENTPROFILE = 4;

  private static final int LAYOUT_FRAGMENTSHIPPING = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.melikeey.shoppingdemo.R.layout.fragment_basket, LAYOUT_FRAGMENTBASKET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.melikeey.shoppingdemo.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.melikeey.shoppingdemo.R.layout.fragment_product_detail, LAYOUT_FRAGMENTPRODUCTDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.melikeey.shoppingdemo.R.layout.fragment_profile, LAYOUT_FRAGMENTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.melikeey.shoppingdemo.R.layout.fragment_shipping, LAYOUT_FRAGMENTSHIPPING);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTBASKET: {
          if ("layout/fragment_basket_0".equals(tag)) {
            return new FragmentBasketBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_basket is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPRODUCTDETAIL: {
          if ("layout/fragment_product_detail_0".equals(tag)) {
            return new FragmentProductDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_product_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPROFILE: {
          if ("layout/fragment_profile_0".equals(tag)) {
            return new FragmentProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSHIPPING: {
          if ("layout/fragment_shipping_0".equals(tag)) {
            return new FragmentShippingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_shipping is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "fragment");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/fragment_basket_0", com.melikeey.shoppingdemo.R.layout.fragment_basket);
      sKeys.put("layout/fragment_home_0", com.melikeey.shoppingdemo.R.layout.fragment_home);
      sKeys.put("layout/fragment_product_detail_0", com.melikeey.shoppingdemo.R.layout.fragment_product_detail);
      sKeys.put("layout/fragment_profile_0", com.melikeey.shoppingdemo.R.layout.fragment_profile);
      sKeys.put("layout/fragment_shipping_0", com.melikeey.shoppingdemo.R.layout.fragment_shipping);
    }
  }
}
