package com.relateddigital.shoppingdem;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.relateddigital.shoppingdem.databinding.ActivityMainBindingImpl;
import com.relateddigital.shoppingdem.databinding.FragmentBasketBindingImpl;
import com.relateddigital.shoppingdem.databinding.FragmentHomeBindingImpl;
import com.relateddigital.shoppingdem.databinding.FragmentLoginBindingImpl;
import com.relateddigital.shoppingdem.databinding.FragmentMainBindingImpl;
import com.relateddigital.shoppingdem.databinding.FragmentProductDetailBindingImpl;
import com.relateddigital.shoppingdem.databinding.FragmentProfileBindingImpl;
import com.relateddigital.shoppingdem.databinding.FragmentRegisterBindingImpl;
import com.relateddigital.shoppingdem.databinding.FragmentShippingBindingImpl;
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
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_FRAGMENTBASKET = 2;

  private static final int LAYOUT_FRAGMENTHOME = 3;

  private static final int LAYOUT_FRAGMENTLOGIN = 4;

  private static final int LAYOUT_FRAGMENTMAIN = 5;

  private static final int LAYOUT_FRAGMENTPRODUCTDETAIL = 6;

  private static final int LAYOUT_FRAGMENTPROFILE = 7;

  private static final int LAYOUT_FRAGMENTREGISTER = 8;

  private static final int LAYOUT_FRAGMENTSHIPPING = 9;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(9);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.relateddigital.shoppingdem.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.relateddigital.shoppingdem.R.layout.fragment_basket, LAYOUT_FRAGMENTBASKET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.relateddigital.shoppingdem.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.relateddigital.shoppingdem.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.relateddigital.shoppingdem.R.layout.fragment_main, LAYOUT_FRAGMENTMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.relateddigital.shoppingdem.R.layout.fragment_product_detail, LAYOUT_FRAGMENTPRODUCTDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.relateddigital.shoppingdem.R.layout.fragment_profile, LAYOUT_FRAGMENTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.relateddigital.shoppingdem.R.layout.fragment_register, LAYOUT_FRAGMENTREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.relateddigital.shoppingdem.R.layout.fragment_shipping, LAYOUT_FRAGMENTSHIPPING);
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
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
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
        case  LAYOUT_FRAGMENTLOGIN: {
          if ("layout/fragment_login_0".equals(tag)) {
            return new FragmentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMAIN: {
          if ("layout/fragment_main_0".equals(tag)) {
            return new FragmentMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_main is invalid. Received: " + tag);
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
        case  LAYOUT_FRAGMENTREGISTER: {
          if ("layout/fragment_register_0".equals(tag)) {
            return new FragmentRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_register is invalid. Received: " + tag);
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
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(9);

    static {
      sKeys.put("layout/activity_main_0", com.relateddigital.shoppingdem.R.layout.activity_main);
      sKeys.put("layout/fragment_basket_0", com.relateddigital.shoppingdem.R.layout.fragment_basket);
      sKeys.put("layout/fragment_home_0", com.relateddigital.shoppingdem.R.layout.fragment_home);
      sKeys.put("layout/fragment_login_0", com.relateddigital.shoppingdem.R.layout.fragment_login);
      sKeys.put("layout/fragment_main_0", com.relateddigital.shoppingdem.R.layout.fragment_main);
      sKeys.put("layout/fragment_product_detail_0", com.relateddigital.shoppingdem.R.layout.fragment_product_detail);
      sKeys.put("layout/fragment_profile_0", com.relateddigital.shoppingdem.R.layout.fragment_profile);
      sKeys.put("layout/fragment_register_0", com.relateddigital.shoppingdem.R.layout.fragment_register);
      sKeys.put("layout/fragment_shipping_0", com.relateddigital.shoppingdem.R.layout.fragment_shipping);
    }
  }
}
