package wang.angi.sample.mybatis.spring.boot.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import wang.angi.sample.mybatis.spring.boot.starter.dao.CityDao;
import wang.angi.sample.mybatis.spring.boot.starter.domain.City;
import wang.angi.sample.mybatis.spring.boot.starter.domain.Hotel;
import wang.angi.sample.mybatis.spring.boot.starter.mapper.CountryMapper;
import wang.angi.sample.mybatis.spring.boot.starter.mapper.HotelMapper;

@SpringBootApplication
public class MybatisSpringBootApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(getClass()); 
	
    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringBootApplication.class, args);
    }

    private final HotelMapper hotelMapper;

    private final CityDao cityDao;

    private final CountryMapper countryMapper;

    public MybatisSpringBootApplication(HotelMapper hotelMapper, CityDao cityDao, CountryMapper countryMapper) {
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
//        System.out.println(cityDao.insertCity(city));

//        System.out.println(cityDao.selectCityByExample().size());

//        System.out.println(this.countryMapper.selectCountryById(1));

        logger.info(this.cityDao.selectCityById(1).toString());

        logger.info(this.hotelMapper.selectHotelById(1).toString());
        // 打开二级缓存，下面的sql不会执行
        logger.info(this.hotelMapper.selectHotelById(1).toString());
        logger.info(this.hotelMapper.selectHotelById(1).toString());
        logger.info(this.hotelMapper.selectHotelById(1).toString());
        logger.info(this.hotelMapper.selectHotelByExample(new Hotel()).toString());
    }

}
