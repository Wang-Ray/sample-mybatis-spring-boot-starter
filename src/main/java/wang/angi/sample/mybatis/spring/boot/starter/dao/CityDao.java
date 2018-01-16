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
package wang.angi.sample.mybatis.spring.boot.starter.dao;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import wang.angi.sample.mybatis.spring.boot.starter.domain.City;

import java.util.List;

/**
 * 使用SQLSession操作
 *
 * @author Eddú Meléndez
 */
@Component
public class CityDao {

    private final SqlSession sqlSession;

    public CityDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public City selectCityById(long id) {
        City city = this.sqlSession.selectOne("selectCityById", id);
        // 二级缓存开启时，下面的sql不会触发执行
        City city1 = this.sqlSession.selectOne("selectCityById", id);
        return city;
    }

    public int insertCity(City city) {
        return this.sqlSession.insert("insertCity", city);
    }

    public List<City> selectCityByExample() {
        return this.sqlSession.selectList("selectCityByExample", new City(), new RowBounds(2, 3));
    }
}
