package com.bank.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CoordinatesConverter {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @SuppressWarnings("unchecked")
    public String getCoordinates(String address){

        String json = restTemplate
                .getForObject("https://geocode-maps.yandex.ru/1.x/?apikey=5273d717-3842-4498-a707-751cf83e99c1&geocode="+"{address}"+"&format=json", String.class,address);

        try {
            String coordinates = json;
            Map<String, Object> responseMap = objectMapper.readValue(coordinates, new TypeReference<>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            });

            Map<String, Object> geoObjectCollection = (Map<String, Object>) responseMap.get("response");
            Map<String, Object> metaDataProperty = (Map<String, Object>) geoObjectCollection.get("GeoObjectCollection");
            List featureMember = (List) metaDataProperty.get("featureMember");
            LinkedHashMap<String,Object> s = (LinkedHashMap<String, Object>) featureMember.get(0);
            LinkedHashMap<String,Object> s2 = (LinkedHashMap<String, Object>) s.get("GeoObject");
            LinkedHashMap<String,String> s3 = (LinkedHashMap<String,String>) s2.get("Point");

            String preAnswer = s3.get("pos");

            return preAnswer.substring(preAnswer.indexOf(" ")+1)+" " +preAnswer.substring(0,preAnswer.indexOf(" "));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
