package com.fan1tuan.dao.support.mapReduce;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Li He on 2014/4/11.
 * JavaScript Extractor
 * @author Li He
 */
public class JavaScriptExtractor {
    private static final String TOKEN = "->";

    public static String getFunction(String fullName) throws Exception{
        int delimiterIndex = fullName.lastIndexOf(TOKEN);
        String location,function;
        if(delimiterIndex==-1){
            //no TOKEN specified, choose the first function in js source file
            location = fullName;
            function = null;

        }else{
            location = fullName.substring(0,delimiterIndex).trim();
            function = fullName.substring(delimiterIndex+TOKEN.length()).trim();
        }

        //wildcard pattern, usually first function in javascript file
        if(function==null||"".equals(function)){
            function = "[\\$0-9a-zA-Z_\\-]+";
        }

        Resource resource = new ClassPathResource(location);
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line=reader.readLine())!=null){
            sb.append(line).append("\n");
        }

        //cache the content of file
        String content = sb.toString();

        Pattern pattern = Pattern.compile("function[\\s]+"+function+"[\\s]*\\([\\s]*\\)",Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(content);

        if(matcher.find()){
            //System.out.println(matcher.group(0));
            //System.out.println(content.substring(matcher.end(0)));

            String ret = content.substring(matcher.end(0));
            Pattern inner = Pattern.compile("([\\{\\}])",Pattern.MULTILINE);
            Matcher innerM = inner.matcher(ret);

            Stack<String> stack = new Stack<>();

            int endIndex = 0;
            while(innerM.find(endIndex)){
                if(innerM.group(1).equals("{")){
                    stack.push(innerM.group(1));
                }else if(innerM.group(1).equals("}")){
                    if(stack.size()==0)
                        throw new RuntimeException("Match Failed!");
                    else{
                        stack.pop();
                        if(stack.size()==0){
                            endIndex = innerM.end(0);
                            break;
                        }
                    }
                }
                endIndex = innerM.end(0);
            }

            if(stack.size()==0){
                return "function ()"+ret.substring(0,endIndex);
            }
        }

        return "";
    }

    public static void main(String[] args) throws Exception{
        System.out.println(getFunction("area.js->test"));
    }
}
