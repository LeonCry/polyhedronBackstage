package com.leon.mapper;

import com.leon.pojo.Chats;
import com.leon.pojo.PicInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PicInfoMapper {
//    返回所有图片信息 但是有page限制
List<PicInfo> returnPics( @Param("picId")int picId,@Param("pageStart")int pageStart, @Param("pageEnd") int pageEnd);
PicInfo returnPicsById( @Param("picId")int picId);
//添加一个图片信息
int InsertPic(PicInfo picInfo);
//删除一个图片
int delPic(@Param("picId")int picId);
//更新一个图片的信息
int updatePic(PicInfo picInfo);

}
