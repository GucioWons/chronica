package com.chronica.notification.logic.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class PropertyTransfer {
    public static void copyNonNullProperties(Object source, Object target) {
       BeanWrapper srcWrap = new BeanWrapperImpl(source);
       PropertyDescriptor[] pds = srcWrap.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for(PropertyDescriptor pd : pds) {
            Object srcValue = srcWrap.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        BeanUtils.copyProperties(source, target, emptyNames.toArray(result));
    }
}
