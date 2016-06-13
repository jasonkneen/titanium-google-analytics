/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package analytics.google;

import java.util.HashMap;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.util.TiConvert;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;


@Kroll.proxy(creatableInModule=AnalyticsGoogleModule.class)
public class TrackerProxy extends KrollProxy
{
  // Standard Debugging variables
  private static final String LCAT = "TrackerProxy";

  private final Tracker tracker;
  private boolean anonymizeIPEnabled = false;

  // Constructor
  public TrackerProxy(Tracker t)
  {
    super();
    tracker = t;
  }

  // https://developers.google.com/analytics/devguides/collection/android/v4/advanced#anonymizeIp
  @Kroll.getProperty
  public boolean getAnonymizeIP()
  {
    return anonymizeIPEnabled;
  }

  @Kroll.setProperty
  public void setAnonymizeIP(boolean enabled)
	{
    anonymizeIPEnabled = enabled;
		tracker.setAnonymizeIp(enabled);
	}

  // https://developers.google.com/analytics/devguides/collection/android/v4/user-id
  @Kroll.method
  public void setUser(HashMap props)
  {
    KrollDict propsDict = new KrollDict(props);
    String category = TiConvert.toString(propsDict, "category");
    String action = TiConvert.toString(propsDict, "action");
    String userId = TiConvert.toString(propsDict, "userId");

    tracker.set("&uid", userId);

    // TODO: https://productforums.google.com/forum/#!topic/analytics/278xuhDXv0s
    HitBuilders.EventBuilder hitBuilder = new HitBuilders.EventBuilder()
        .setCategory(category).setAction(action);

    // custom dimension
    Object cd = propsDict.get("customDimension");
    if (cd instanceof HashMap) {
      HashMap dict = (HashMap) cd;
      for (Object key : dict.keySet()) {
        int idx = TiConvert.toInt(key);
        String val = TiConvert.toString(dict.get(key));

        if (idx > 0) {
          hitBuilder.setCustomDimension(idx, val);
        }
      }
    }

    // custom metric
    Object cm = propsDict.get("customMetric");
    if (cm instanceof HashMap) {
      HashMap dict = (HashMap) cm;

      for (Object key : dict.keySet()) {
        int idx = TiConvert.toInt(key);
        float val = TiConvert.toFloat(dict.get(key));

        if (idx > 0) {
          hitBuilder.setCustomMetric(idx, val);
        }
      }
    }

    tracker.send(hitBuilder.build());
  }

  // https://developers.google.com/analytics/devguides/collection/ios/v3/events
  @Kroll.method
  public void trackEvent(HashMap props)
  {
    KrollDict propsDict = new KrollDict(props);
    String category = TiConvert.toString(propsDict, "category");
    String action = TiConvert.toString(propsDict, "action");
    String label = TiConvert.toString(propsDict, "label");

    // TODO: https://productforums.google.com/forum/#!topic/analytics/278xuhDXv0s
    HitBuilders.EventBuilder hitBuilder = new HitBuilders.EventBuilder()
        .setCategory(category).setAction(action).setLabel(label);

    Object vo = propsDict.get("value");
    if (vo != null) {
      long value = TiConvert.toInt(propsDict, "value");
      hitBuilder.setValue(value);
    }

    // custom dimension
    Object cd = propsDict.get("customDimension");
    if (cd instanceof HashMap) {
      HashMap dict = (HashMap) cd;
      for (Object key : dict.keySet()) {
        int idx = TiConvert.toInt(key);
        String val = TiConvert.toString(dict.get(key));

        if (idx > 0) {
          hitBuilder.setCustomDimension(idx, val);
        }
      }
    }

    // custom metric
    Object cm = propsDict.get("customMetric");
    if (cm instanceof HashMap) {
      HashMap dict = (HashMap) cm;

      for (Object key : dict.keySet()) {
        int idx = TiConvert.toInt(key);
        float val = TiConvert.toFloat(dict.get(key));

        if (idx > 0) {
          hitBuilder.setCustomMetric(idx, val);
        }
      }
    }

    tracker.send(hitBuilder.build());
  }

  // https://developers.google.com/analytics/devguides/collection/android/v4/social
  @Kroll.method
  public void trackSocial(HashMap props)
  {
    KrollDict propsDict = new KrollDict(props);
    String network = TiConvert.toString(propsDict, "network");
    String action = TiConvert.toString(propsDict, "action");
    String target = TiConvert.toString(propsDict, "target");


    // TODO: https://productforums.google.com/forum/#!topic/analytics/278xuhDXv0s
    HitBuilders.SocialBuilder hitBuilder = new HitBuilders.SocialBuilder()
        .setNetwork(network).setAction(action).setTarget(target);

    // custom dimension
    Object cd = propsDict.get("customDimension");
    if (cd instanceof HashMap) {
      HashMap dict = (HashMap) cd;
      for (Object key : dict.keySet()) {
        int idx = TiConvert.toInt(key);
        String val = TiConvert.toString(dict.get(key));

        if (idx > 0) {
          hitBuilder.setCustomDimension(idx, val);
        }
      }
    }

    // custom metric
    Object cm = propsDict.get("customMetric");
    if (cm instanceof HashMap) {
      HashMap dict = (HashMap) cm;

      for (Object key : dict.keySet()) {
        int idx = TiConvert.toInt(key);
        float val = TiConvert.toFloat(dict.get(key));

        if (idx > 0) {
          hitBuilder.setCustomMetric(idx, val);
        }
      }
    }

    tracker.send(hitBuilder.build());
  }

  // https://developers.google.com/analytics/devguides/collection/android/v4/usertimings
  @Kroll.method
  public void trackTiming(HashMap props)
  {
    KrollDict propsDict = new KrollDict(props);
    String category = TiConvert.toString(propsDict, "category");
    String name = TiConvert.toString(propsDict, "name");
    String label = TiConvert.toString(propsDict, "label");
    long interval = TiConvert.toInt(propsDict, "time");

    // TODO:
    // https://productforums.google.com/forum/#!topic/analytics/278xuhDXv0s
    HitBuilders.TimingBuilder hitBuilder = new HitBuilders.TimingBuilder()
        .setCategory(category).setValue(interval).setVariable(name)
        .setLabel(label);


    // custom dimension
    Object cd = propsDict.get("customDimension");
    if (cd instanceof HashMap) {
      HashMap dict = (HashMap) cd;
      for (Object key : dict.keySet()) {
        int idx = TiConvert.toInt(key);
        String val = TiConvert.toString(dict.get(key));

        if (idx > 0) {
          hitBuilder.setCustomDimension(idx, val);
        }
      }
    }

    // custom metric
    Object cm = propsDict.get("customMetric");
    if (cm instanceof HashMap) {
      HashMap dict = (HashMap) cm;

      for (Object key : dict.keySet()) {
        int idx = TiConvert.toInt(key);
        float val = TiConvert.toFloat(dict.get(key));

        if (idx > 0) {
          hitBuilder.setCustomMetric(idx, val);
        }
      }
    }

    tracker.send(hitBuilder.build());
  }

  // https://developers.google.com/analytics/devguides/collection/android/v4/screens
  @Kroll.method
  public void trackScreen(HashMap props)
  {
    KrollDict propsDict = new KrollDict(props);
    String screenName = TiConvert.toString(propsDict, "screenName");

    tracker.setScreenName(screenName);

    // TODO: https://productforums.google.com/forum/#!topic/analytics/278xuhDXv0s
    HitBuilders.AppViewBuilder hitBuilder = new HitBuilders.AppViewBuilder();

    // custom dimension
    Object cd = propsDict.get("customDimension");
    if (cd instanceof HashMap) {
      HashMap dict = (HashMap) cd;
      for (Object key : dict.keySet()) {
        int idx = TiConvert.toInt(key);
        String val = TiConvert.toString(dict.get(key));

        if (idx > 0) {
          hitBuilder.setCustomDimension(idx, val);
        }
      }
    }

    // custom metric
    Object cm = propsDict.get("customMetric");
    if (cm instanceof HashMap) {
      HashMap dict = (HashMap) cm;

      for (Object key : dict.keySet()) {
        int idx = TiConvert.toInt(key);
        float val = TiConvert.toFloat(dict.get(key));

        if (idx > 0) {
          hitBuilder.setCustomMetric(idx, val);
        }
      }
    }

    tracker.send(hitBuilder.build());
  }

  // https://developers.google.com/analytics/devguides/collection/android/v4/ecommerce
  @Kroll.method
  public void trackTransaction(HashMap props) {
    KrollDict propsDict = new KrollDict(props);

    String transactionId = TiConvert.toString(propsDict, "transactionId");
    String affiliation = TiConvert.toString(propsDict, "affiliation");
    Double revenue = TiConvert.toDouble(propsDict, "revenue");
    Double tax = TiConvert.toDouble(propsDict, "tax");
    Double shipping = TiConvert.toDouble(propsDict, "shipping");
    String currency = TiConvert.toString(propsDict, "currency");

    // TODO:
    // https://productforums.google.com/forum/#!topic/analytics/278xuhDXv0s
    HitBuilders.TransactionBuilder hitBuilder = new HitBuilders.TransactionBuilder()
        .setTransactionId(transactionId).setAffiliation(affiliation)
        .setRevenue(revenue).setTax(tax).setShipping(shipping)
        .setCurrencyCode(currency);

    // custom dimension
    Object cd = propsDict.get("customDimension");
    if (cd instanceof HashMap) {
      HashMap dict = (HashMap) cd;
      for (Object key : dict.keySet()) {
        int idx = TiConvert.toInt(key);
        String val = TiConvert.toString(dict.get(key));

        if (idx > 0) {
          hitBuilder.setCustomDimension(idx, val);
        }
      }
    }

    // custom metric
    Object cm = propsDict.get("customMetric");
    if (cm instanceof HashMap) {
      HashMap dict = (HashMap) cm;

      for (Object key : dict.keySet()) {
        int idx = TiConvert.toInt(key);
        float val = TiConvert.toFloat(dict.get(key));

        if (idx > 0) {
          hitBuilder.setCustomMetric(idx, val);
        }
      }
    }

    tracker.send(hitBuilder.build());
  }


  // https://developers.google.com/analytics/devguides/collection/android/v4/ecommerce
  @Kroll.method
  public void trackTransactionItem(HashMap props) {
    KrollDict propsDict = new KrollDict(props);

    String transactionId = TiConvert.toString(propsDict, "transactionId");
    String name = TiConvert.toString(propsDict, "name");
    String sku = TiConvert.toString(propsDict, "sku");
    String category = TiConvert.toString(propsDict, "category");
    Double price = TiConvert.toDouble(propsDict, "price");
    Double quantity = TiConvert.toDouble(propsDict, "quantity");
    String currency = TiConvert.toString(propsDict, "currency");

    // TODO:
    // https://productforums.google.com/forum/#!topic/analytics/278xuhDXv0s
    HitBuilders.ItemBuilder hitBuilder = new HitBuilders.ItemBuilder()
        .setTransactionId(transactionId).setName(name).setSku(sku)
        .setCategory(category).setPrice(price)
        .setQuantity(Math.round(quantity))
        .setCurrencyCode(currency);

    // custom dimension
    Object cd = propsDict.get("customDimension");
    if (cd instanceof HashMap) {
      HashMap dict = (HashMap) cd;
      for (Object key : dict.keySet()) {
        int idx = TiConvert.toInt(key);
        String val = TiConvert.toString(dict.get(key));

        if (idx > 0) {
          hitBuilder.setCustomDimension(idx, val);
        }
      }
    }

    // custom metric
    Object cm = propsDict.get("customMetric");
    if (cm instanceof HashMap) {
      HashMap dict = (HashMap) cm;

      for (Object key : dict.keySet()) {
        int idx = TiConvert.toInt(key);
        float val = TiConvert.toFloat(dict.get(key));

        if (idx > 0) {
          hitBuilder.setCustomMetric(idx, val);
        }
      }
    }

    tracker.send(hitBuilder.build());
  }


  @Kroll.method
  public void trackException(HashMap props) {
    KrollDict propsDict = new KrollDict(props);
    String description = TiConvert.toString(propsDict, "description");
    Boolean fatal;
    
    if (propsDict.containsKey("fatal")) {
    	fatal = TiConvert.toBoolean(propsDict, "fatal");
    } else {
    	fatal = false;
    }

    tracker.send(new HitBuilders.ExceptionBuilder()
      .setDescription(description)
      .setFatal(fatal)
      .build());
  }


}
