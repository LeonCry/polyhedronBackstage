package com.leon.service.impl;

import com.leon.mapper.SysNoticeMapper;
import com.leon.pojo.SysNotice;
import com.leon.service.SysNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysNoticeServiceImpl implements SysNoticeService {

    @Autowired
    private SysNoticeMapper sysNoticeMapper;

//    添加一条通知信息
    @Override
    public int addOneNotice(SysNotice sysNotice) {
        return sysNoticeMapper.addOneNotice(sysNotice);
    }

//根据接收方用户名筛选处系统通知
    @Override
    public List<SysNotice> selectByReceiveUserQQ(String receiveUserQQ) {
       return sysNoticeMapper.selectSysNoticeByReceiveUserQQ(receiveUserQQ);

    }

//  筛选指定条件的系统通知,为了防止多次好友请求
    @Override
    public SysNotice selectSysNoticeNoRepeat(String receiveUserQQ, String sendUserQQ) {
        return sysNoticeMapper.selectSysNoticeNoRepeat(receiveUserQQ, sendUserQQ);
    }

    //    根据发送方用户名筛选处系统通知
    @Override
    public List<SysNotice> selectBySendQQ(String sendUserQQ) {
        return sysNoticeMapper.selectSysNoticeBySendUserQQ(sendUserQQ);
    }

//    更新数据
    @Override
    public int updateData(SysNotice sysNotice) {
        return sysNoticeMapper.updateSysNoticeData(sysNotice);
    }

    @Override
    public int delOneNotice(int sysNoticeId) {
        return sysNoticeMapper.delOneNotice(sysNoticeId);
    }

    @Override
    public SysNotice mailInFiveMs(String sendUserQQ, String receiveUserQQ, int noticeType) {
        return sysNoticeMapper.mailInFiveMs(sendUserQQ,receiveUserQQ,noticeType);
    }

    @Override
    public List<SysNotice> returnAllNotice() {
        return sysNoticeMapper.returnAllNotice();
    }
}
