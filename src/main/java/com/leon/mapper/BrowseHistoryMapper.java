package com.leon.mapper;

import com.leon.pojo.BrowseHistory;
import com.leon.pojo.PXdetails;
import com.leon.pojo.ShopOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BrowseHistoryMapper {

    //    查询所有浏览历史
    List<BrowseHistory> returnAllBrowseHistory();
    //    根据ID查浏览历史
    BrowseHistory returnBrowseHistoryById(@Param("browseId") int browseId);
    //    根据名字查浏览历史
    List<BrowseHistory> returnBrowseHistoryByName( @Param("browseUser") String browseUser);
    //    插入一条商品浏览历史
    int addABrowseHistory(BrowseHistory browseHistory);
    //    修改一条商品浏览历史
    int updateABrowseHistory(BrowseHistory browseHistory);
    //    删除所有浏览历史根据用户名
    int delABrowseHistory(@Param("browseUser") String browseUser);

}
