/**
 * Copyright 2015-2017 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package wang.angi.sample.mybatis.spring.boot.starter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wang.angi.sample.mybatis.spring.boot.starter.dao.CityDao;
import wang.angi.sample.mybatis.spring.boot.starter.domain.City;
import wang.angi.sample.mybatis.spring.boot.starter.mapper.CountryMapper;
import wang.angi.sample.mybatis.spring.boot.starter.mapper.HotelMapper;

@SpringBootApplication
public class SampleXmlApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SampleXmlApplication.class, args);
    }

    private final HotelMapper hotelMapper;

    private final CityDao cityDao;

    private final CountryMapper countryMapper;

    public SampleXmlApplication(HotelMapper hotelMapper, CityDao cityDao, CountryMapper countryMapper) {
        this.hotelMapper = hotelMapper;
        this.cityDao = cityDao;
        this.countryMapper = countryMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        City city = new City();
        city.setName("WuHan");
        city.setState("HuBei");
        city.setCountry("China");
        city.setCreatedBy("水晶");
        System.out.println(cityDao.insertCity(city));
        System.out.println(city);
        System.out.println(this.countryMapper.selectCountryById(1));
        System.out.println(this.cityDao.selectCityById(1));
        System.out.println(this.hotelMapper.selectHotelById(1));
    }

}
