package com.gvv.java_projet_m1;

import com.gvv.entity.Brand;
import com.gvv.mapper.BrandMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JavaProjetM1ApplicationTests {

    @Autowired
    private BrandMapper brandMapper;

    @Test
    public void BrandMapperTest() {
        List<Brand> brands = brandMapper.selectList(null);
        brands.forEach(System.out::println);
    }

    @Test
    public void BrandMapperInsertTest() {
        Brand b = new Brand();
        b.setBrandName("test1");
        brandMapper.insert(b);
        System.out.println(b.getBrandId());
    }

}
