package com.mjf.es.esdemo.reponsitory;

import com.mjf.es.esdemo.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @ProjectName: house
 * @Package: com.mjf.es.esdemo.reponsitory
 * @ClassName: ItemReponsitory
 * @Author: majiafei
 * @Description:
 * @Date: 2019/6/2 20:12
 */
public interface ItemReponsitory extends ElasticsearchRepository<Item, Long> {

    List<Item> findItemByPriceBetween(double p1, double p2);

}
