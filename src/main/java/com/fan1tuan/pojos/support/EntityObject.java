package com.fan1tuan.pojos.support;

import com.fan1tuan.util.DateUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * convenient entity object class
 */
public class EntityObject {
    public static final String GETTER_PREFIX = "get";
    public static final String IS_PREFIX = "is";


    /**
     * 生成JSONObject，可以序列化为字符串
     * @return JSONObject
     */
    public JSONObject toJSON(){
        try{
            Method[] methods = getClass().getDeclaredMethods(); //获取声明的全部methods

            JSONObject json = new JSONObject();

            for(Method method : methods){
                String fieldName = null;

				/*
				 * 判断是否为getter method，如果为getter method，赋值fieldName
				 */
                if(method.getName().startsWith(GETTER_PREFIX)){
                    fieldName = Character.toLowerCase(method.getName().charAt(GETTER_PREFIX.length()))+method.getName().substring(GETTER_PREFIX.length()+1);
                }else if(method.getName().startsWith(IS_PREFIX)){
                    fieldName = Character.toLowerCase(method.getName().charAt(IS_PREFIX.length()))+method.getName().substring(IS_PREFIX.length()+1);
                }

				/*
				 * fieldName不为空，此方法为getter method
				 */
                if(fieldName!=null){
                    Field field = getClass().getDeclaredField(fieldName);  //获取Field对象
                    boolean ormField = false; //是否为orm框架关联注释字段
                    //必须排除@ManyToOne @ManyToMany @OneToMany的情况
                    Annotation[] annotations = field.getDeclaredAnnotations();
                    for(Annotation annotation : annotations){
                        String annotationName = annotation.annotationType().getSimpleName();
                        if(annotationName.equals("ManyToOne")||annotationName.equals("OneToMany")||annotationName.equals("ManyToMany")){
                            ormField = true;
                            break;
                        }
                    }

                    if(!ormField){
                        Object object = method.invoke(this, (Object[])null);

                        json.put(fieldName, getJsonObject(object));
                    }

                }
            }

            return json;

        }catch(Exception exception){
            //System.err.println("Error Occurs!");
            exception.printStackTrace();
            return null;
        }
    }

    /**
     * 递归获取可以put到JSONObject中的对象
     * @param object send me object to parse to JSON-related Object
     * @return json-related object
     */
    @SuppressWarnings("rawtypes")
    private Object getJsonObject(Object object){

        if(object==null){
            return null;
        }

        if(object instanceof EntityObject){ //字段对象为EntityObject
            object = ((EntityObject)object).toJSON();
        }else if(object instanceof Date){  //字段对象为Date
            object = DateUtil.dateToString((Date) object);
        }else if(object instanceof Map){
            JSONObject jsonObject = new JSONObject();
            for(Object obj : ((Map)object).entrySet()){
                Map.Entry entry = (Map.Entry)obj;
                //如果为map，必须保证key为String
                jsonObject.put(entry.getKey().toString(), getJsonObject(entry.getValue()));
            }

            object = jsonObject;

        }else if(object instanceof Collection){
            JSONArray jsonArray = new JSONArray();

            for(Object obj : (Collection)object){
                jsonArray.put(getJsonObject(obj));
            }

            object = jsonArray;
        }

        return object;
    }


}
