package com.first.blog.repository;

import com.first.blog.Application;
import com.first.blog.blogstart.BlogStartApplicationTests;
import com.first.blog.domain.es.EsBlog;
import com.first.blog.repository.es.EsBlogRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * EsBlog Repository  接口测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
//@SpringBootTest(classes = BlogStartApplicationTests.class)


public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRRepositoryData(){
        //清除所有数据
        esBlogRepository.deleteAll();

        esBlogRepository.save(new EsBlog("登燕雀楼","王之涣的登燕雀楼","白日依山尽，黄河入海流。 欲穷千里目，更上一层楼。"));
        esBlogRepository.save(new EsBlog("静夜思","李白的静夜思","白日依山尽，黄河入海流。欲穷千里目，更上一层楼。"));
        esBlogRepository.save(new EsBlog("相思","王维的相思","床前明月光，疑是地上霜。举头望明月，低头思故乡。"));


    }

    /**
     * 分页查询博客（去重)
     * @return
     */
    @Test
    public void  testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(){
        Pageable pageable = new PageRequest(0,20);
        String title = "思";
        String summary = "相思";
        String content = "相思";
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);
        assertThat(page.getTotalElements()).isEqualTo(2);

        System.out.println("-------------------start 1");
        for (EsBlog blog : page.getContent()){
            System.out.println(blog.toString());
        }
        System.out.println("-------------------end 1");
    }
}
