//package com.bank.utils;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Map;
//
//@Component
//@RequiredArgsConstructor
//public class CoordinatesConverter {
//    private final RestTemplate restTemplate;
//
//
//    public String getCoordinates(String address){
//        System.out.println(address);
//        String json = restTemplate.getForObject("https://geocode-maps.yandex.ru/1.x/?apikey=5273d717-3842-4498-a707-751cf83e99c1&geocode="+"{address}"+"&format=json", String.class,address);
//
//        try {
//            String coordinates = json;
//            Map<String, Object> responseMap = objectMapper.readValue(coordinates, new TypeReference<Map<String, Object>>() {
//                @Override
//                public Type getType() {
//                    return super.getType();
//                }
//            });
//            Map<String, Object> geoObjectCollection = (Map<String, Object>) responseMap.get("response");
//            Map<String, Object> metaDataProperty = (Map<String, Object>) geoObjectCollection.get("GeoObjectCollection");
//            List featureMember = (List) metaDataProperty.get("featureMember");
//            //Map<String, Object> coordinate = (Map<String, Object>) coordinat.get("GeoObject");
//            LinkedHashMap<String,Object> s = (LinkedHashMap<String, Object>) featureMember.get(0);
//            //String answer = s.substring(s.indexOf("Point"));
//            LinkedHashMap<String,Object> s2 = (LinkedHashMap<String, Object>) s.get("GeoObject");
//
//            LinkedHashMap<String,String> s3 = (LinkedHashMap<String,String>) s2.get("Point");
//
//            String preAnswer = s3.get("pos");
//            System.out.println(preAnswer);
//            String answer = preAnswer.substring(preAnswer.indexOf(" ")+1)+" " +preAnswer.substring(0,preAnswer.indexOf(" "));
//            System.out.println(answer);
//
//            return answer;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
