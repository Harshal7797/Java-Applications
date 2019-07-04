package ca.jrvs.apps.twitter.example.JsonParser;

import ca.jrvs.apps.twitter.example.JsonParser.dto.Dividend;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JasonParser <T> {

    /**
     *Convert a java object to JSON string
     * @param object input object
     * @return JSON String
     * @throws JsonProcessingException
     */

    public static String toJson (Object object, boolean prettyJson, boolean includeNullValues) throws JsonProcessingException {

        try{
            ObjectMapper mapper =new ObjectMapper();
        mapper.writeValue(new File("/home/centos/dev/jrvs/bootcamp/java_apps/result.json"), object);
        String json= mapper.writeValueAsString(object);
            return json;
        }catch (IOException x){
            x.printStackTrace();
            throw new RuntimeException(x);
        }
    }

    /**
     * parse JSON string to a object
     * @param json
     * @param clazz object class
     * @param <T> Type
     * @return object
     * @throws IOException
     */

    public static <T> T toObjectFromJson(String json, Class clazz)throws IOException{
       try {
           ObjectMapper mapper = new ObjectMapper();
           T cp = (T) mapper.readValue(json, clazz);
           System.out.println("Printing CP");
           System.out.println(cp);
           return cp;
       }catch (IOException e){
           e.printStackTrace();
           throw new RuntimeException(e);
       }
    }

    public static void main(String[] args) throws IOException {
        Dividend dividend=new Dividend();
        dividend.setExDate("2018-02-09");
        dividend.setPaymentDate("2018-02-15");
        dividend.setRecordDate("2018-02-01");
        dividend.setDeclaredDate("2018-02-01");
        dividend.setAmount(0.63);
        Dividend dividend1=new Dividend();
        String test = toJson(dividend, false, false);

JasonParser <Dividend>  xx= new JasonParser();
               Dividend xxx =  toObjectFromJson(test,Dividend.class);


    }
    }