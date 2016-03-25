package in.byzas.lib;

import in.byzas.annotation.MapperProperty;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by byzas on 25/03/16.
 */
public class Mapper {

    public static Object map(Object sourceObject, Class targetClass){
        try {
            Object targetObject = null;

            if(sourceObject instanceof List){
                List<Object> targetObjects = new ArrayList<>();
                Iterator<Object> iterater = ((List) sourceObject).iterator();
                while (iterater.hasNext()){
                    targetObject = targetClass.newInstance();
                    Object sobj = iterater.next();
                    Class sourceClass = sobj.getClass();
                    Field[] targetObjectFields = targetClass.getDeclaredFields();
                    for (Field targetField : targetObjectFields) {
                        if (targetField.isAnnotationPresent(MapperProperty.class)) {
                            MapperProperty mp = targetField.getAnnotation(MapperProperty.class);
                            Field sourceField = sourceClass.getDeclaredField(mp.mappedProperty());
                            sourceField.setAccessible(true);
                            targetField.setAccessible(true);
                            targetField.set(targetObject, sourceField.get(sobj));
                        }
                    }
                    targetObjects.add(targetObject);
                }

                return targetObjects;
            }else{
                targetObject = targetClass.newInstance();
                Class sourceClass = sourceObject.getClass();
                Field[] targetObjectFields = targetClass.getDeclaredFields();
                for (Field targetField : targetObjectFields) {
                    if (targetField.isAnnotationPresent(MapperProperty.class)) {
                        MapperProperty mp = targetField.getAnnotation(MapperProperty.class);
                        Field sourceField = sourceClass.getDeclaredField(mp.mappedProperty());
                        sourceField.setAccessible(true);
                        targetField.setAccessible(true);
                        targetField.set(targetObject, sourceField.get(sourceObject));
                    }
                }

                return targetObject;
            }



        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
