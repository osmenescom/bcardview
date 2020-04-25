package com.asgeirr.businesscard;

import android.text.TextUtils;

public class CommonUtils {
    public static boolean equals(Object o1, Object o2){
        if(o1==null && o2==null)
            return true;
        if(o1 instanceof Long || o2 instanceof Long){
            return (o1==null &&  ((Long) o2)==0L)|| (o2==null && ((Long) o1)==0L) || (o1!=null && o2!=null && ((Long) o1).longValue()==((Long) o2).longValue());
        } else if( o1 instanceof String || o2 instanceof String) {
            return (o1 == null && TextUtils.isEmpty((String) o2)) || (TextUtils.isEmpty((String) o1) && o2 == null) || (o1 != null && o1.equals(o2));
        }else if( o1 instanceof Integer || o2 instanceof Integer){
            return (o1==null && ((Integer) o2)==0)|| (o2==null && ((Integer) o1)==0) || (o1!=null && o2!=null && ((Integer) o1).compareTo((Integer) o2) == 0);
        } else if( o1 instanceof Double || o2 instanceof Double){
            return (o1==null && ((Double) o2)==0)|| (o2==null && ((Double) o1)==0) || (o1!=null && o2!=null && (((Double) o1).compareTo((Double) o2) == 0));
        } else if( o1 instanceof Float || o2 instanceof Float){
            return (o1==null && ((Float) o2)==0F)|| (o2==null && ((Float) o1)==0F) || (o1!=null && o2!=null && (((Float) o1).compareTo((Float) o2) == 0));
        } else if( o1 instanceof Boolean || o2 instanceof Boolean){
            return (o1==null && !((Boolean) o2))|| (o2==null && !((Boolean) o1)) || (o1!=null && o2!=null && ((Boolean) o1).compareTo((Boolean) o2) == 0);
        } else  if( o1 instanceof Short || o2 instanceof Short){
            return (o1==null && ((Short) o2)==0)|| (o2==null && ((Short) o1)==0) || (o1!=null && o2!=null && ((Short) o1).compareTo((Short) o2) == 0);
        } else
            return o1!=null && o1.equals(o2);
    }
}
