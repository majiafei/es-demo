package com.mjf.es.esdemo.elasticsearch;

import com.mjf.es.esdemo.EsDemoApplicationTests;
import com.mjf.es.esdemo.entity.Item;
import com.mjf.es.esdemo.reponsitory.ItemReponsitory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: house
 * @Package: com.mjf.es.esdemo.elasticsearch
 * @ClassName: IndexTest
 * @Author: majiafei
 * @Description:
 * @Date: 2019/6/2 20:09
 */
public class IndexTest extends EsDemoApplicationTests {

    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    private ItemReponsitory itemReponsitory;

    @Test
    public void testCreateIndex() {
        template.createIndex(Item.class);
        template.putMapping(Item.class);
    }

    @Test
    public void testSave() {
        Item item = new Item();
        item.setBrand("华为");
        item.setCategory("手机");
        item.setId(1L);
        item.setPrice(2300.00);
        item.setTitle("华为 HUAWEI nova 4e 3200万立体美颜AI超广角三摄珍珠屏4GB+128GB幻夜黑全网通版双4G手机");

        itemReponsitory.save(item);
    }

    @Test
    public void batchInsert() {
        List<Item> itemList = new ArrayList<>();
        Item item = new Item();
        item.setTitle("荣耀8X 千元屏霸 91%屏占比 2000万AI双摄 4GB+64GB 幻夜黑 移动联通电信4G全面屏手机 双卡双待");
        item.setId(2L);
        item.setPrice(1199.00);
        item.setImages("https://img14.360buyimg.com/n1/s450x450_jfs/t1/21333/14/5246/180334/5c3ad7b6Ef7d727c0/c16e93d0bf77a31f.jpg");
        item.setCategory("手机");
        item.setBrand("华为");
        itemList.add(item);

        itemReponsitory.saveAll(itemList);
    }

    @Test
    public void testSelect() {
        List<Item> itemByPriceBetween = itemReponsitory.findItemByPriceBetween(1000, 2000);
        System.out.println(itemByPriceBetween.size());
    }

}
